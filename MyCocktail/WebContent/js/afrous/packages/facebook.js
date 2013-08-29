/*
 * MyCocktail Mashup Builder
 * David del Pozo González (dpozog--at--grupogesfor.com)
 * Copyright 2008 - 2010 Informática Gesfor
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
 * Services.Romulus Package
 * 
 * This service is a test REST service developed for a demostration.
 * var "url" must be setup to invoke the correct URL.
 */

(function() {

var facebook = new afrous.UnitActionPackage('Services.Facebook', {
  label : 'Facebook',  
  icon : 'http://uwi.sh/images/social/facebook-icon.png'
});


facebook.register(new afrous.UnitAction({
  type : 'URLlike',
  label : 'Count likes',
  description : 'Counts Facebook likes of an URL',
  inputs : [
    { name : 'entity',
      label : 'entity',
      type : 'String'
      }
  ]
  ,
  execute : function(request, callback) {

    var url = null;
    var baseUrl = 'http://graph.facebook.com/?ids=';
    var entity = request.params['entity'];
    if( (entity.indexOf("http")== -1) && (entity.indexOf(".")>0)){
        
        entity= "http://"+entity;
    }
    url=baseUrl+entity;

    afrous.ajax.jsonp.invoke(url, {
      onSuccess : function(ret) {
        if (ret !=null && ret[entity] !=null && ret[entity].shares == null) {
            ret[entity].shares = 0;
        }
        callback.onSuccess(ret);
        //callback.onSuccess(ret[entity].shares);
      },
      onFailure : callback.onFailure
    });
  }


}));


afrous.packages.register(facebook, 'facebook.js');

})();