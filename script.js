const http = require('https');
const path = require('path')
const url = require('url')
const fs = require('fs')
const os = require('os')
var exec = require('child_process').exec;
var spawn = require('child_process').spawn;
const request = require('request')

function addProgress(maxval){
    var progressbar = $('#progressbar'),
      max = progressbar.attr('max'),
      value = progressbar.val(),
      time = (1000/max)*5;

    $(() => {
      let progressbar = $('#progressbar');
      let max = maxval;
      let time = (1000 / max) * 5;
      let value = progressbar.val();
      const loading = () => {
          value += 1;
          progressbar.val(value);
          $('.progress-value').html(value + '%');
          if (value == max) {
              clearInterval(animate);
          }
      };
      const animate = setInterval(() => loading(), time);
    });
  }

function downloadFile(){

const download = (fileurl, filepath, callback) => {
    request.head(fileurl, (err, res, body) => {
      request(fileurl)
        .pipe(fs.createWriteStream(filepath))
        .on('close', callback)
    })
  }
  
  const fileurl = 'https://github.com/BNH440/Minecraft-Modding/archive/1.0.zip'
  const filepath = './mods.zip'
  
  download(fileurl, filepath, () => {
    console.log('Done!')
  })
  


}


  fs.createReadStream('./mods.zip')
    .pipe(unzipper.Extract({ path: './mods' }));