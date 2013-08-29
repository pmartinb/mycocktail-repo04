/*
 * MyCocktail Mashup Builder
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

google.setOnLoadCallback(function (){

  Ext.onReady(function() {
    var app = new afrous.editor.EditorApp();
    Ext.EventManager.addListener(window, 'beforeunload', app.checkDirty, app);
    Ext.EventManager.addListener(window, 'unload', app.checkDirty, app);
    afrous.editor.app = app;
  });
  
});