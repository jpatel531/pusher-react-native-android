/**
 * @providesModule Pusher
 */
var { NativeModules } = require('react-native');

var pusher = NativeModules.Pusher;

pusher.listen = function(channelName, eventName, _callback){
  var callback = function(data){
    _callback(JSON.parse(data));
  }
  pusher.mListen(channelName, eventName, callback);
};

module.exports = pusher;