/*
 * Copyright 2011 Logica
 * David del Pozo González (david.del.pozo--at--logica.com)
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
var mashupParams = null;
var globalMashupResult = null;
function executeMashup(json){
    var procdef = new afrous.ProcessDef(json);
    var proc = new afrous.ProcessInstance(procdef);

    if(mashupParams != null) {
        var keys = afrous.lang.keys(mashupParams);
        for(var i=0; i<keys.length; i++) {
            proc.setParam(keys[i], mashupParams[keys[i]]);
        }
    }

    proc.start(function(result){
        globalMashupResult = afrous.lang.toJSON(result);
    });
    return globalMashupResult;
}