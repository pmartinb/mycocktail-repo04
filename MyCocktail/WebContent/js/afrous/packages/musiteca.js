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

(function() {

var musiteca = new afrous.UnitActionPackage('Services.Musiteca', {
  label : 'Musiteca',
  icon : 'http://musiteca.grupogesfor.com/musiteca-theme/images/liferay.ico'
});

var ENTITY = {
    PERFORMER : 'Performer',
    COMPOSER  : 'music_teacher',
    CONDUCTOR : 'Conductor'
}

var PROFESSION = {
    SINGER    : 'Singer',
    PIANIST   : 'Pianist',
    CONDUCTOR : 'Conductor',
    COMPOSER  : 'Composer'
}

musiteca.register(new afrous.UnitAction({
  type : 'MusitecaSearch',
  label : 'Musiteca Search',
  description : 'Make Search from Musiteca',
  inputs : [
    { name : 'entity',
      label : 'Entity',
      type : 'String',
      options : ["", ENTITY.PERFORMER,
                     ENTITY.COMPOSER, ENTITY.CONDUCTOR] },
     { name : 'profession',
      label : 'Profession',
      type : 'String',
      options : ["", PROFESSION.SINGER,    PROFESSION.PIANIST,
                     PROFESSION.CONDUCTOR, PROFESSION.COMPOSER] },
    { name : 'name',
      label : 'Name',
      type : 'String' },
    { name : 'instrument',
      label : 'Instrument',
      type : 'String' },
    { name : 'nationality',
      label : 'Nationality',
      type : 'String' },
    { name : 'residence',
      label : 'Place of Residence',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var entity      = request.params['entity']      || null;
    var profession  = request.params['profession']  || null;
    var name        = request.params['name']        || null;
    var instrument  = request.params['instrument']  || null;
    var nationality = request.params['nationality'] || null;
    var residence   = request.params['residence']   || null;

    var query = {}
    if(entity)
      query['type'] = '/base/musiteca/'+entity.toLowerCase();
    if(profession)
      query['/people/person/profession~='] = profession;
    query['/people/person/profession'] = [];
    if(name)
      query['name~='] = "*"+name+"*";
    if(nationality)
      query['/people/person/nationality~='] = nationality;
    query['/people/person/nationality'] = [];
    if(residence)
      query['/base/musiteca/performer/place_of_residence'] = residence;
    query['/people/person/place_of_birth'] = null;
    if(instrument)
        query['/music/group_member/instruments_played~='] = instrument;
    query["/music/group_member/instruments_played"] = [];
    query['*'] = null;

    var queryParam = { query : [query]}

    var url = 'http://api.freebase.com/api/service/mqlread?query=' + afrous.lang.toJSON(queryParam);

    afrous.ajax.jsonp.invoke(url, callback);
  }

}));

musiteca.register(new afrous.UnitAction({
  type : 'AlbumSearch',
  label : 'Album Search',
  description : 'Search music albums from Musiteca',
  inputs : [
    { name : 'albumName',
      label : 'Album Name',
      type : 'String' },
    { name : 'artistName',
      label : 'Artist Name',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var albumName  = request.params['albumName']  || null;
    var artistName = request.params['artistName'] || null;

    var query = {}
    query['id'] = null;
    if(artistName)
        query['name~='] = "*"+artistName+"*";
    query['name'] = null,
    query['type'] = "/base/musiteca/music_teacher";
    var album = {}
    album['id']           = null;
    album["name"]         = null;
    album["release_date"] = null;
    album["artist"]       = [];
    if(albumName)
        album['name~='] = "*"+albumName+"*";
    query['/music/artist/album'] = [album];

    var queryParam = { query : [query]}

    var url = 'http://api.freebase.com/api/service/mqlread?query=' + afrous.lang.toJSON(queryParam);

    afrous.ajax.jsonp.invoke(url, callback);
  }

}));

musiteca.register(new afrous.UnitAction({
  type : 'VideoSearch',
  label : 'Video Search',
  description : 'Search videos from Musiteca',
  inputs : [
    { name : 'name',
      label : 'Name',
      type : 'String' },
    { name : 'performer',
      label : 'Performer',
      type : 'String' },
    { name : 'conductor',
      label : 'Conductor',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var name        = request.params['name']       || null;
    var conductor   = request.params['conductor']  || null;
    var performer   = request.params['performer']  || null;

    var query = {}
    query['type']  = "/base/musiteca/video";
    query['video'] = null;
    query['name']      = null;
    query['performer'] = null;
    query['conductor'] = null;
    query['id']        = null;
    if(name)
      query['name~='] = "*"+name+"*";
    if(performer)
      query['performer~='] = "*"+performer+"*";
    if(conductor)
      query['conductor~='] = "*"+conductor+"*";


    var queryParam = { query : [query]}

    var url = 'http://api.freebase.com/api/service/mqlread?query=' + afrous.lang.toJSON(queryParam);

    afrous.ajax.jsonp.invoke(url, callback);
  }

}));

musiteca.register(new afrous.UnitAction({
  type : 'AwardSearch',
  label : 'Award Search',
  description : 'Search awards from Musiteca',
  inputs : [
    { name : 'name',
      label : 'Artist Name',
      type : 'String' },
    { name : 'awardName',
      label : 'Award Name',
      type : 'String' },
    { name : 'awardYear',
      label : 'Award Year',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var name        = request.params['name']       || null;
    var awardName   = request.params['awardName']  || null;
    var awardYear   = request.params['awardYear']  || null;

    var query = {};
    query['id'] = null;
    query['type'] = "/base/musiteca/performer";
    if(name)
      query['name~='] = "*"+name+"*";
    query['name'] = null;

    var award = {};
    award['id'] = null;
    if(awardName) {
      award['award~='] = awardName;
      award['award']   = null;
    }
    else
      award['award'] = null;
    if(awardYear)
      award['year'] = awardYear;
    else
      award['year'] = null;
    award['award_winner'] = [];
    query['/award/award_winner/awards_won'] = [award];

    var queryParam = { query : [query]}

    var url = 'http://api.freebase.com/api/service/mqlread?query=' + afrous.lang.toJSON(queryParam);

    afrous.ajax.jsonp.invoke(url, callback);
  }

}));

musiteca.register(new afrous.UnitAction({
  type : 'CompositionSearch',
  label : 'Composition Search',
  description : 'Search compositions from Musiteca',
  inputs : [
    { name : 'name',
      label : 'Name',
      type : 'String' },
    { name : 'composer',
      label : 'Composer',
      type : 'String' },
    { name : 'instrument',
      label : 'Instrument',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var name       = request.params['name']       || null;
    var composer   = request.params['composer']   || null;
    var instrument = request.params['instrument'] || null;

    var query = {};
    query['type'] = "/base/musiteca/composition";
    if(name)
      query['name~='] = "*"+name+"*";
    if(composer)
      query['composer~='] = "*"+composer+"*";
    if(instrument)
      query['instruments_composition~='] = "*"+instrument+"*";
    query['*'] = null;

    var queryParam = { query : [query]}

    var url = 'http://api.freebase.com/api/service/mqlread?query=' + afrous.lang.toJSON(queryParam);

    afrous.ajax.jsonp.invoke(url, callback);
  }

}));

afrous.packages.register(musiteca, 'musiteca.js');

})();
