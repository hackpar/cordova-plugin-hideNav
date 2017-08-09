
/**
 * @return the mac address class instance
 */

var exec = require('cordova/exec');
 var HideNav = {

 	hideNav: function(successCallback, failureCallback){
                exec(successCallback, failureCallback, 'HideNavPlugin',
 			'hideNav', []);
 	},

 	showNav: function(successCallback, failureCallback){
                exec(successCallback, failureCallback, 'HideNavPlugin',
 			'showNav', []);
 	}
 };

 module.exports = HideNav;