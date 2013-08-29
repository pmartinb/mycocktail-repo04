/*
 * José María Jiménez Torrejón (jmjimenezt--at--grupogesfor.com)
 * Copyright 2009 - 2010 Informática Gesfor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Services.ECMSystems Package
 */

(function() {

var ecmsystems = new afrous.UnitActionPackage('Services.ECMSystems', {
  label : 'ECM Systems',
  icon : ''
});

// ECM Contents
ecmsystems.register(new afrous.UnitAction({
  type : 'searchecm',
  label : 'ECM Contents',
  description : 'Content Search.',
  inputs : [
    /*{ name : 'username',
      label : 'Username',
      type : 'String',
      size : 'large' },
    { name : 'password',
      label : 'Password',
      type : 'String',
      size : 'large' },*/
    { name : 'content',
      label : 'Query',
      type : 'String',
      size : 'large' }
  ]
  ,
  execute : function(request, callback) {
    //var username = request.params['username'];
    //var password = request.params['password'];
    var username = 'admin';
    var password = 'admin';
    var content = request.params['content'];

    var url = afrous.baseURL + '/Search?q='+ content +'&user='+ username +'&pwd='+ password;
    
    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
        if (ret[2]=='200') {
          callback.onSuccess(ret[1]);
        } else { 
	  	  callback.onSuccess({ error : ret[2], message : ret[3] });
        } 
      },
      onFailure : callback.onFailure
    });
  }
}));


// ECM Repositories list
ecmsystems.register(new afrous.UnitAction({
  type : 'repolist',
  label : 'ECM Repositories',
  description : 'See the list of available repositories.',
  inputs : [
    /*{ name : 'repoFile',
      label : 'Config File',
      type : 'String',
      size : 'large' }*/
  ]
  ,
  execute : function(request, callback) {
    var url = afrous.baseURL + '/GetRepoList';
    
    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
        if (ret[2]=='200') {
          callback.onSuccess(ret[1]);
        } else { 
	  	  callback.onSuccess({ error : ret[2], message : ret[3] });
        } 
      },
      onFailure : callback.onFailure
    });
    
  }
}));


// Add new ECM Repository
ecmsystems.register(new afrous.UnitAction({
  type : 'addecm',
  label : 'Add new ECM Repository',
  description : 'Add new ECM repository to the list of available repositories.',
  inputs : [
    { name : 'repoInfo',
      label : 'Repository',
      type : 'String',
      size : 'large' },
    { name : 'user',
      label : 'Username',
      type : 'String',
      size : 'large' },
    { name : 'pwd',
      label : 'Password',
      type : 'String',
      size : 'large' }
  ]
  ,
  execute : function(request, callback) {
    var repoInfo = request.params['repoInfo'];
    var user = request.params['user'];
    var pwd = request.params['pwd'];
	
    var url = afrous.baseURL + '/AddNewRepo?user='+ user +'&pwd='+ pwd +'&repoInfo='+ repoInfo;
    
    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
        if (ret[2]=='200') {
          callback.onSuccess(ret[1]);
        } else { 
	  	  callback.onSuccess({ error : ret[2], message : ret[3] });
        } 
      },
      onFailure : callback.onFailure
    });
    
  }
}));


// Get Content Stream
ecmsystems.register(new afrous.UnitAction({
  type : 'getContent',
  label : 'Get Content Stream',
  description : 'Get a content from the repositories.',
  inputs : [
    { name : 'fileName',
      label : 'Filename',
      type : 'String',
      size : 'large' }
    /*{ name : 'fileExt',
      label : 'File extension',
      type : 'String',
      size : 'large',
      options : ['jpg','wmv','flv']},*/
  ]
  ,
  execute : function(request, callback) {
    var fileName = request.params['fileName'];
    //var fileExt = request.params['fileExt'];
    //var contentType = 'iptcMedia:newsmlMedia';
    var contentType = 'iptc:newsml';
    var username = 'admin';
    var password = 'admin';

    //var url = 'http://192.168.4.193:7080/MyCocktail/Contenidos?q='+ fileName + '&contType='+ contentType;
    //var url = afrous.baseURL + '/AddNewRepo?user='+ user +'&pwd='+ pwd +'&repoInfo='+ repoInfo;

    //var url = afrous.baseURL + '/GetContentStream?q='+ fileName + '.' + fileExt + '&contType=' + contentType + '&user='+ username +'&pwd='+ password;
    var url = afrous.baseURL + '/GetContentStream?q='+ fileName + '&contType=' + contentType + '&user='+ username +'&pwd='+ password;

    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
        if (ret[2]=='200') {
          callback.onSuccess(ret[1]);
        } else {
	  	  callback.onSuccess({ error : ret[2], message : ret[3] });
        }
      },
      onFailure : callback.onFailure
    });

  }
}));


afrous.packages.register(ecmsystems, 'ecm_systems.js');

})();
