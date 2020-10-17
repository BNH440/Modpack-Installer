// This file is required by the index.html file and will
// be executed in the renderer process for that window.
// No Node.js APIs are available in this process because
// `nodeIntegration` is turned off. Use `preload.js` to
// selectively enable features needed in the rendering
// process.

//const { ipcRenderer } = require('electron');

//ipcRenderer.send('getFile');
const http = require('https');
const path = require('path')
const url = require('url')
const fs = require('fs')
const os = require('os')
var exec = require('child_process').exec;
var spawn = require('child_process').spawn;
var request = require('request')
var unzipper = require('unzipper');
const editJsonFile = require("edit-json-file");



function renameModsFolder(){
  document.getElementById("progressbar").value = "55"
  document.getElementById("status-label").innerHTML = "Making new directory..."


  //const currPath = process.env.APPDATA + "/.minecraft/mods"
  //const newPath = process.env.APPDATA + "/.minecraft/modsBackupFile"
  /*
  const currPath = "./mods"
  const newPath = "./modsBackupFile"

  fs.rename(currPath, newPath, function(err) {
  if (err) {
      console.log(err)
  } else {
      console.log("Successfully renamed the directory.")
  }
  })  */

  var dir = 'C:/Users/' + os.userInfo().username + '/AppData/Roaming/.minecraftModpack';

  if (!fs.existsSync(dir)){
    fs.mkdirSync(dir);
  }
}


function getFile(){
    gameDir = 'C:/Users/' + os.userInfo().username + '/AppData/Roaming/.minecraftModpack';
    document.getElementById("install-button").style.display = "none"
    document.getElementById("progressbar").style.display = "block"
    document.getElementById("status-label").style.display = "block"

    document.getElementById("progressbar").value = "25"
    document.getElementById("status-label").innerHTML = "Downloading and Extracting Mod Files..."

    const download = (fileurl, filepath, callback) => {
      request.head(fileurl, (err, res, body) => {
        request(fileurl)
          .pipe(fs.createWriteStream(filepath))
          .on('close', callback)
      })
    }
    
    const fileurl = 'https://modpack.page.link/bjYi';
    const filepath = gameDir + '/mods.zip';
  
    download(fileurl, filepath, () => {
      fs.createReadStream(gameDir + '/mods.zip').pipe(unzipper.Extract({ path: gameDir }));
      console.log('Done!')
      document.getElementById("progressbar").value = "50"
    })

    let file = editJsonFile("C:/Users/" + os.userInfo().username + "/AppData/Roaming/.minecraft/launcher_profiles.json");
    
    file.set("profiles.Modpack", {
      //"created": "2018-03-17T21:00:20.119Z",
      "gameDir": gameDir,
      "icon": "TNT",
      //"javaArgs": "-Xmx8G -Dorg.lwjgl.opengl.Window.undecorated=true -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32M",
      //"lastUsed": "2020-07-24T00:31:41.193Z",
      "lastVersionId": "1.12.2-forge-14.23.5.2854",
      "name": "Modpack",
      "type": "custom"
    });

    file.save();
}
