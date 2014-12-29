
var exec = require('cordova/exec');

var prjplugin = {
 echo:function(str, callback) {
	exec(callback, function(err) {
		
		callback(err + ', Nothing to echo.');
	}, "PrjPluginName", "echo", [ str ]);
},
 md5:function(str, callback) {
        exec(callback, function(err) {

                callback(err + ', Nothing to md5.');
        }, "PrjPluginName", "md5", [ str ]);
}

};

module.exports=prjplugin;
