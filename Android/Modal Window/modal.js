var modal = {
  open: function(successCallback, errorCallback, url) {
  	//alert('open');
    cordova.exec(successCallback, errorCallback, 'Modal','open', [ url ]);
  },
  close: function(data) {
    cordova.exec(null, null, 'Modal', 'close', [ data ]);
  }
}

//alert('1');
