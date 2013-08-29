/*
 * MyCocktail Mashup Builder
 * David del Pozo González (dpozog--at--grupogesfor.com)
 * Copyright 2008 - 2011 Informática Gesfor
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
 * Renderer.Telco Package
 * 
 */

//afrous.packages.loadScript('http://s.phono.com/releases/0.2/jquery.phono.js');

function myCocktailPhonoCall(event) {
    var button = event.currentTarget ? event.currentTarget : event.srcElement;
    var div = button.parentNode;
    
    var par    = null;
    var status = null;
    for(var i=0; i<div.childNodes.length; i++) {
        var node = div.childNodes[i];
        if (node.className == "status") {
            status = node;
        } else if (node.className == "phoneNumber") {
            par = node;
        }
    }
   
    var phoneNumber = par.innerHTML;
    
    var phonoObject = null;
    button.value = "Calling...";
    button.disable = true;
    phonoObject = $.phono({ 
        apiKey: "f31aadd521a3860b140f0d090d4f71f9",
        onReady: function() {
            phonoObject.phone.dial(phoneNumber, {
                onRing: function() {
                    status.innerHTML = "Ringing";
                    console.log("Ringing");
                },
                onAnswer: function() {
                    status.innerHTML = "Answered";
                    console.log("Answered");
                },
                onHangup: function() {
                    status.innerHTML = "Hangup";
                    console.log("Hangup");
                    button.name = "Call";
                    button.disable = false;
                }
            });
        }
    });
}

(function() {

    var telcoServices = new afrous.UnitActionPackage('Renderer.Telco', {
      label : 'Telco'/*,
      icon : 'http://www.w3c.org/2008/site/images/favicon.ico' */
    });

    telcoServices.register(new afrous.RenderingUnitAction({
      type : 'Call',
      label : 'Call',
      description : 'Call Service',
      iconCls : 'phono-call-uaction',
      inputs : [
        { name : 'phoneNumber',
          label : 'phoneNumber',
          type : 'String' }
      ]
      ,
      render : function(params, el) {
        var phoneNumber = params['phoneNumber'];  
        el.innerHTML =  '<div class="omelettePhoneCall">'+
                        '<p class="phoneNumber">'+phoneNumber+'</p>'+
                        '<input class="callButton" type="button" onclick="myCocktailPhonoCall(event);" value="Call" />'+
                        '<span class="status"></span>'+
                        '</div>';
      }

    }));

    afrous.packages.register(telcoServices, 'telcoservices.js');
        
})();

    