/*
 * MyCocktail Page Editor
 * David del Pozo González (dpozog--at--grupogesfor.com)
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

var romulus;
if(!romulus)
  romulus = {};

(function(){

  romulus.mashupsDisplayer = {
    loadMashup:function (mshpId,htmlElement,parameters,callback)
    {
      if(!mshpId || !htmlElement)
        return;

      if(!parameters)
        parameters = afrous.url.getUrlParameters();

      afrous.ajax.jsonp.invoke(afrous.config.PROCESS_REGISTRY_URL +'?id='+mshpId+'&json=1', function(json) {
        afrous.lang.forEach(afrous.lang.values(json.requires), function(url){
          afrous.lang.loadScript(url);
        });

        afrous.packages.waitLoadComplete(
          afrous.lang.keys(json.requires),
          function()
          {
            var procdef = new afrous.ProcessDef(json);
            var proc = new afrous.ProcessInstance(procdef);
            afrous.lang.forEach(json.params, function(param, i) {
              var paramValue = parameters[param.name];
              if(!paramValue)
                paramValue = param['default'];
              proc.setParam(param.name, paramValue);
            });
            proc.start(function(result){
              var el = null;
              if(afrous.lang.isDOMNode(htmlElement))
                el = htmlElement;
              else if(afrous.lang.isString(htmlElement))
              {
                el = document.getElementById(htmlElement);
                if(!el)
                  el = document.getElementsByName(htmlElement);
              }
              if(el!=null) {
                result.render(el);
                if(callback) {
                  callback();
                }
              }
            });
          }
        );
      });
    }
  }
})();
