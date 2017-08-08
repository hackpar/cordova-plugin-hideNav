
/**
 * @return the mac address class instance
 */
 var HideNav = {

 	hideNav: function(successCallback, failureCallback){
 		cordova.exec(successCallback, failureCallback, 'HideNavPlugin',
 			'hideNav', []);
 	}
 };

 module.exports = HideNav;