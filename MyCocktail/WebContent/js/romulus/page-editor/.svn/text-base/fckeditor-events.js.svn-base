/*
 * MyCocktail Page Editor
 * David del Pozo González (dpozog--at--grupogesfor.com)
 * Copyright 2009 - 2010  Informática Gesfor
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

var counter     = 0;
var initialized = false;
function FCKeditor_OnComplete( editorInstance )
{
  romulus.pageEditor.app.registerEditor(editorInstance);
  counter++;
  if(counter == 14 && !initialized)
  {
    initialized = true;
    romulus.pageEditor.app.initializeWhenEditorsAreLoaded();

    if (/MSIE (\d+\.\d+);/.test(navigator.userAgent))
    {
      Ext.MessageBox.alert('Browser not compatible',
        "You browser does not support all MyCocktail functionalities. <br><br>"+
        "Supported browsers: "+
        "<ul><li> - Mozilla Firefox</li>"+
        "<li> - Opera</li>"+
        "<li> - Chrome</li>"+
        "<li> - Safari</li></ul>"
      );
    }
  }

  editorInstance.Events.AttachEvent( 'OnAfterSetHTML', function(){
    romulus.pageEditor.app.setCSSClass(romulus.pageEditor.app.cssClass);
  }) ;
}

