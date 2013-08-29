/*
 * MyCocktail
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
 * Services.Omelette Package
 * 
 * This service is a test REST service developed for a demostration.
 * var "url" must be setup to invoke the correct URL.
 */

(function() {

var omelette = new afrous.UnitActionPackage('Services.Omelette', {
  label : 'Omelette',  
  icon : 'http://www.ict-omelette.eu/Omelette-tmp-theme/images/liferay.ico"'
});

omelette.register(new afrous.UnitAction({
  type : 'IntCampusEdu',
  label : 'Int. Campus Education',
  description : 'Service which retrieves information of the International Campus Education',
  allowDynamicInput : true,
  inputs : [
    { name : 'entity',
      label : 'Retrieve info from',
      type : 'String',
      options : ["Students"] }
  ]
  ,
  execute : function(request, callback) {
    var obj = { students : 
        [{ name:"david", 
           place:"Madrid", 
           phone:"347-708-1142",
           myCocktailIcon: afrous.editor?afrous.editor.Iconizer.getIcon('user'):undefined},
         { name:"john",  
           place:"London", 
           phone:"347-708-1141",
           myCocktailIcon: afrous.editor?afrous.editor.Iconizer.getIcon('user'):undefined}]
    };
    callback.onSuccess(obj);
  }


}));

afrous.packages.register(omelette, 'omelette.js');

})();