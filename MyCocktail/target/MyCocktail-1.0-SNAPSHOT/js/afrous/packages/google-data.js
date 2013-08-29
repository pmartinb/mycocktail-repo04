/*
 * MyCocktail Mashup Builder
 * Copyright 2011 Logica
 * David del Pozo González (david.del.pozo--at--logica.com)
 * Rodrigo Illera Camargo (rodrigo.illera--at--logica.com)
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
 * Services.GoogleData Package
 */

(function() {

var googData = new afrous.UnitActionPackage('Services.GoogleData', {
  label : 'Google Data',
  icon : 'http://www.google.com/favicon.ico'
});

googData.contactParser = {
    getValue : function(json) {
        return json?json.getValue():undefined;
    }
    ,
    
    nameToJson : function(name) {
        var json = {};
        json.fullName = this.getValue(name.getFullName());
        json.namePrefix = this.getValue(name.getNamePrefix());
        json.nameSuffix = this.getValue(name.getNameSuffix());
        json.givenName = this.getValue(name.getGivenName());
        json.familyName = this.getValue(name.getFamilyName());
        json.additionalName = this.getValue(name.getAdditionalName());
        return json;
    }
    ,
    
    emailToJson : function(email) {
        var json = {};
        json.label   = email.getLabel();
        json.address = email.getAddress();
        json.primary = email.getPrimary();
        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'email');
        if(google.gdata.Email.REL_HOME == email.getRel()) {
            json.rel = "Home";
        } else if(google.gdata.Email.REL_OTHER == email.getRel()) {
            json.rel = "Other";
        } else if(google.gdata.Email.REL_WORK == email.getRel()) {
            json.rel = "Work";
        } else {
            json.rel = undefined;
        } 
        return json;
    }
    ,
     
    phoneToJson : function(phone) {
        var json = {};
        json.label   = phone.getLabel();
        json.value   = phone.getValue();
        json.primary = phone.getPrimary();
        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'telephone');
        if(google.gdata.PhoneNumber.REL_FAX == phone.getRel()) {
            json.rel = "Fax";
            if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'fax');
        } else if(google.gdata.PhoneNumber.REL_HOME == phone.getRel()) {
            json.rel = "Home";
        } else if(google.gdata.PhoneNumber.REL_HOME_FAX == phone.getRel()) {
            json.rel = "Home fax";
            if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'fax');
        } else if(google.gdata.PhoneNumber.REL_MOBILE == phone.getRel()) {
            json.rel = "Cell phone";
            if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'phone');
        } else if(google.gdata.PhoneNumber.REL_OTHER == phone.getRel()) {
            json.rel = "Other";
        } else if(google.gdata.PhoneNumber.REL_PAGER == phone.getRel()) {
            json.rel = "Pager";
        } else if(google.gdata.PhoneNumber.REL_WORK == phone.getRel()) {
            json.rel = "Work";
        } else if(google.gdata.PhoneNumber.REL_WORK_FAX == phone.getRel()) {
            json.rel = "Work Fax";
            if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'fax');
        } else {
            json.rel = undefined;
        }
        return json;
    }
    ,
    
    organizationToJson : function(organization) {
        var json = {};
        json.label = organization.getLabel();
        json.name = this.getValue(organization.getOrgName());
        json.title = this.getValue(organization.getOrgTitle());
        json.symbol = this.getValue(organization.getOrgSymbol());
        json.name = this.getValue(organization.getOrgName());
        json.jobDescription = this.getValue(organization.getOrgJobDescription());
        json.primary = organization.getPrimary()
        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'building');
        if(google.gdata.Organization.REL_OTHER == organization.getRel()) {
            json.rel = "Other";
        } else if(google.gdata.Organization.REL_WORK == organization.getRel()) {
            json.rel = "Work";
        } else {
            json.rel = undefined;
        } 
        return json;
    }
    ,
    
    postalAddressToJson : function(postalAddress) {        
        var json = {};
        json.label   = postalAddress.getLabel();
        json.value   = postalAddress.getValue();
        json.primary = postalAddress.getPrimary();
        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'house');
        if(google.gdata.PostalAddress.REL_HOME == postalAddress.getRel()) {
            json.rel = "Home";
        } else if(google.gdata.PostalAddress.REL_OTHER == postalAddress.getRel()) {
            json.rel = "Other";
        } else if(google.gdata.PostalAddress.REL_WORK == postalAddress.getRel()) {
            json.rel = "Work";
            if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'building');
        } else {
            json.rel = undefined;
        } 
        return json;
    }
    ,
    
    structuredPostalAddressToJson : function(postalAddress) {        
        var json = {};
        json.label        = postalAddress.getLabel();
        json.primary      = postalAddress.getPrimary(); 
        
        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'house');
        if(google.gdata.StructuredPostalAddress.REL_HOME == postalAddress.getRel()) {
            json.rel = "Home";
        } else if(google.gdata.StructuredPostalAddress.REL_OTHER == postalAddress.getRel()) {
            json.rel = "Other";
        } else if(google.gdata.StructuredPostalAddress.REL_WORK == postalAddress.getRel()) {
            json.rel = "Work";
            if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'building');
        } else {
            json.rel = undefined;
        }
        
        json.formattedAddress = this.getValue(postalAddress.getFormattedAddress());
        
        if(google.gdata.StructuredPostalAddress.USAGE_GENERAL == postalAddress.getUsage()) {
            json.usage = "General";
        } else if(google.gdata.StructuredPostalAddress.USAGE_LOCAL == postalAddress.getUsage()) {
            json.usage = "Local";
        } else {
            json.usage = undefined;
        }
        
        if(google.gdata.StructuredPostalAddress.MAILCLASS_BOTH == postalAddress.getMailClass()) {
            json.mailclass = "Both structured postal address";
        } else if(google.gdata.StructuredPostalAddress.MAILCLASS_LETTERS == postalAddress.getMailClass()) {
            json.mailclass = "Letters structured postal address";
        } else if(google.gdata.StructuredPostalAddress.MAILCLASS_NEITHER == postalAddress.getMailClass()) {
            json.mailclass = "Neither structured postal address";
        } else if(google.gdata.StructuredPostalAddress.MAILCLASS_PARCELS == postalAddress.getMailClass()) {
            json.mailclass = "Parcels structured postal address";
        } else {
            json.mailclass = undefined;
        }
        
        json.agent        = this.getValue(postalAddress.getAgent());
        json.housename    = this.getValue(postalAddress.getHousename());
        json.street       = this.getValue(postalAddress.getStreet());
        json.PoBox        = this.getValue(postalAddress.getPobox());
        json.neighborhood = this.getValue(postalAddress.getNeighborhood());
        json.city         = this.getValue(postalAddress.getCity());
        json.subregion    = this.getValue(postalAddress.getSubregion());
        json.region       = this.getValue(postalAddress.getRegion());
        json.postcode     = this.getValue(postalAddress.getPostcode());
        json.country      = this.getValue(postalAddress.getCountry());
        json.countryCode  = postalAddress.getCountry()?postalAddress.getCountry().getCode():undefined;
        
        return json;
    }
    ,
    
    genderToJson : function(gender) {
        if(gender) {
            return gender.getValue();
        }
        return undefined;
    }
    ,
    
    birthdayToJson : function(birthday) {
        if(birthday) {
            return birthday.getWhen();
        }
        return undefined;
    }
    ,
    
    websiteToJson : function(website) {
        var json = {};
        json.label   = website.getLabel();
        json.uri     = website.getHref();
        json.primary = website.getPrimary();
        if(google.gdata.contacts.Website.REL_BLOG == website.getRel()) {
            json.rel = "Blog";
        } else if(google.gdata.contacts.Website.REL_FTP == website.getRel()) {
            json.rel = "FTP";
        } else if(google.gdata.contacts.Website.REL_HOME == website.getRel()) {
            json.rel = "Home";
        } else if(google.gdata.contacts.Website.REL_HOME_PAGE == website.getRel()) {
            json.rel = "Home Page";
        } else if(google.gdata.contacts.Website.REL_OTHER == website.getRel()) {
            json.rel = "Other";
        } else if(google.gdata.contacts.Website.REL_PROFILE == website.getRel()) {
            json.rel = "Profile";
        } else if(google.gdata.contacts.Website.REL_WORK == website.getRel()) {
            json.rel = "Work";
        } else {
            json.rel = undefined;
        } 
        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'world');
        return json;
    }
    ,
    
    eventToJson : function(event) {
        var json = {};
        json.label = event.getLabel();
        json.when  = event.getWhen()?this.whenToJson(event.getWhen()):undefined;
        if(google.gdata.contacts.Event.REL_ANNIVERSARY == event.getRel()) {
            json.rel = "Anniversary event";
        } else if(google.gdata.contacts.Website.REL_OTHER == event.getRel()) {
            json.rel = "Other event";
        } else {
            json.rel = undefined;
        } 
        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'calendar');
        return json;
    }
    ,
    
    whenToJson : function(when) {
        var json = {};
        json.startTime = when.getStartTime()?this.dateToJson(when.getStartTime()):undefined;
        json.endTime = when.getEndTime()?this.dateToJson(when.getEndTime()):undefined;
        json.reminder = when.getReminder()?this.remindersToJson(when.getReminder()):undefined;
        json.value = when.getValueString();
        return json;
    }
    ,
    
    dateToJson : function(date) {
        var json = {};
        json.date = date.getDate();
        json.iso8601 = google.gdata.DateTime.toIso8601(date);
        json.dateOnly = date.isDateOnly();
        return json;
    }
    ,
    
    reminderToJson : function(reminder) {
        var json = {};
        json.absoluteTime = this.dateToJson(reminder.getAbsoluteTime());
        json.days = reminder.getDays();
        json.hours = reminder.getHours();
        json.mintes = reminder.getMinutes();
        json.method = reminder.getMethod();
        
        if(google.gdata.Reminder.METHOD_ALERT == reminder.getMethod()) {
            json.method = "Calendar";
        } else if(google.gdata.Reminder.METHOD_ALL == reminder.getMethod()) {
            json.method = "All";
        } else if(google.gdata.Reminder.METHOD_EMAIL == reminder.getMethod()) {
            json.method = "Email";
        } else if(google.gdata.Reminder.METHOD_NONE == reminder.getMethod()) {
            json.method = "None";
        } else if(google.gdata.Reminder.METHOD_SMS == reminder.getMethod()) {
            json.method = "SMS";
        } else {
            json.method = undefined;
        }
        
        return json;
    }
    ,
    
    contactToJson : function(contactEntry, token) {
        var contact = {};
        contact.title = contactEntry.getTitle()?contactEntry.getTitle().getText():undefined;
        contact.name = contactEntry.getName()?this.nameToJson(contactEntry.getName()):undefined;
        contact.gender = this.genderToJson(contactEntry.getGender());
//        contact.photo = contactEntry.getContactPhotoLink()?contactEntry.getContactPhotoLink().getHref():undefined;
        contact.occupation = this.getValue(contactEntry.getOccupation());
        contact.emails = this.emailsToJson(contactEntry.getEmailAddresses());
        contact.phones = this.phonesToJson(contactEntry.getPhoneNumbers());
        contact.organizations = this.organizationsToJson(contactEntry.getOrganizations());
        contact.postalAddresses = this.postalAddressesToJson(contactEntry.getPostalAddresses());
        contact.structuredPostalAddresses = this.structuredPostalAddressesToJson(contactEntry.getStructuredPostalAddresses());  
        contact.birthday = this.birthdayToJson(contactEntry.getBirthday());   
        contact.websites = this.websitesToJson(contactEntry.getWebsites()); 
        contact.events = this.eventsToJson(contactEntry.getEvents());
        
        if(afrous.editor) {
            contact.myCocktailName = contact.title;
            afrous.editor.Iconizer.addIconToJson(contact,'user');
            if(contact.gender) {
                if(contact.gender == 'female') {
                    afrous.editor.Iconizer.addIconToProperty(contact,'gender','user_female');
                } else if(contact.gender == 'male') {
                    afrous.editor.Iconizer.addIconToProperty(contact,'gender','user_male');
                }
            }
            afrous.editor.Iconizer.addIconToProperty(contact,'title','vcard');
            afrous.editor.Iconizer.addIconToProperty(contact,'name','note');
            afrous.editor.Iconizer.addIconToProperty(contact,'occupation','lorry');
//            afrous.editor.Iconizer.addIconToProperty(contact,'photo','camera');
            afrous.editor.Iconizer.addIconToProperty(contact,'birthday','cake');
            afrous.editor.Iconizer.addIconToProperty(contact,'emails','email');
            afrous.editor.Iconizer.addIconToProperty(contact,'phones','phone');
            afrous.editor.Iconizer.addIconToProperty(contact,'organizations','building');
            afrous.editor.Iconizer.addIconToProperty(contact,'postalAddresses','house');
            afrous.editor.Iconizer.addIconToProperty(contact,'structuredPostalAddresses','house');
            afrous.editor.Iconizer.addIconToProperty(contact,'websites','world');
            afrous.editor.Iconizer.addIconToProperty(contact,'events','calendar');
        }
        return contact;
    }
    ,
    
    emailsToJson : function(emailAddresses) {
        var newArray = [];
        for (var j = 0; j < emailAddresses.length; j++) {
            newArray.push(this.emailToJson(emailAddresses[j]));
        }
        return newArray;
    }
    ,
    
    phonesToJson : function(phoneNumbers) {
        var newArray = [];
        for (var j = 0; j < phoneNumbers.length; j++) {
            newArray.push(this.phoneToJson(phoneNumbers[j]));
        }
        return newArray;
    }
    ,
    
    organizationsToJson : function(organizations) {
        var newArray = [];
        for (var j = 0; j < organizations.length; j++) {
            newArray.push(this.organizationToJson(organizations[j]));
        }
        return newArray;
    }
    ,
    
    postalAddressesToJson : function(postalAddress) {
        var newArray = [];
        for (var j = 0; j < postalAddress.length; j++) {
            newArray.push(this.postalAddressToJson(postalAddress[j]));
        }
        return newArray;
    }
    ,
    
    structuredPostalAddressesToJson : function(structuredPostalAddress) {
        var newArray = [];
        for (var j = 0; j < structuredPostalAddress.length; j++) {
            newArray.push(this.structuredPostalAddressToJson(structuredPostalAddress[j]));
        }
        return newArray;
    }
    ,
    
    websitesToJson : function(websites) {
        var newArray = [];
        for (var j = 0; j < websites.length; j++) {
            newArray.push(this.websiteToJson(websites[j]));
        }
        return newArray;
    }
    ,
    
    eventsToJson : function(events) {
        var newArray = [];
        for (var j = 0; j < events.length; j++) {
            newArray.push(this.eventToJson(events[j]));
        }
        return newArray;
    }
    ,
    
    remindersToJson : function(reminders) {
        var newArray = [];
        for (var j = 0; j < reminders.length; j++) {
            newArray.push(this.reminderToJson(reminders[j]));
        }
        return newArray;
    }
    ,
    
    contactsToJson : function(contacts, myQuery, token) {
        var newArray = [];
        for (var j = 0; j < contacts.length || (myQuery.maxResults && newArray.length >= myQuery.maxResults); j++) {
            var contact = this.contactToJson(contacts[j], token);
            if (myQuery.email && contact.emails.length == 0) {
                continue;
            }
            if (myQuery.phone && contact.phones.length == 0) {
                continue;
            }
            if (myQuery.address && contact.structuredPostalAddresses.length == 0) {
                continue;
            }
            newArray.push(contact);
        }
        return newArray;
    }
};

googData.calendarParser = {

    calendarToJson : function(calendar) {
        var json = {};
        json.title   = calendar.getTitle()?calendar.getTitle().getText():'';
        json.summary = calendar.getSummary()?calendar.getSummary().getText():'';
        json.updated = calendar.getUpdated().$t;
        json.link = calendar.getLink().getHref();

        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'calendar');
        return json;
    },

    calendarsToJson : function(calendars) {
        var newArray = [];
        for (var j = 0; j < calendars.length; j++) {
            newArray.push(this.calendarToJson(calendars[j]));
        }
        return newArray;
    },

    calendarEventToJson : function(event) {
        var json = {};
        json.title   = event.getTitle()?event.getTitle().getText():'';
        json.content = event.getContent()?event.getContent().getText():'';

        if(google.gdata.EventStatus.VALUE_CANCELED == event.getEventStatus().getValue()) {
            json.status = "Cancelled";
            /*if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'fax');*/
        }else if(google.gdata.EventStatus.VALUE_CONFIRMED == event.getEventStatus().getValue()) {
            json.status = "Confirmed";
        }else if(google.gdata.EventStatus.VALUE_TENTATIVE == event.getEventStatus().getValue()) {
            json.status = "Tentative";
        }else{
            json.status = "Undefined";
        }

        json.location = event.getLocations().length!=0?event.getLocations()[0].getValueString():'';
        json.startTime = event.getTimes().length!=0?event.getTimes()[0].startTime:'';
        json.endTime = event.getTimes().length!=0?event.getTimes()[0].endTime:'';


        if(afrous.editor) afrous.editor.Iconizer.addIconToJson(json,'event');
        return json;
    },

     calendarEventsToJson : function(events) {
        var newArray = [];
        for (var j = 0; j < events.length; j++) {
            newArray.push(this.calendarEventToJson(events[j]));
        }
        return newArray;
    }

};

googData.register(new afrous.UnitAction({
  type : 'contactsdata',
  label : 'Contact Search',
  iconCls : 'contact-operator-uaction',
  description : 'Google Contacts Data API: This service returns your contacts',
  inputs : [
    {name : 'searchBy',
      label : 'Search by',
      type : 'String',
      options : ['Contacts','Groups'/*,'Profiles'*/]},
    {name : 'searchPattern',
      label : 'Search Pattern',
      type : 'String'},
    {name : 'email',
      label : 'Contact with email',
      type : 'String',
      formElement : "CHECK_BOX"},
    {name : 'phone',
      label : 'Contact with phone',
      type : 'String',
      formElement : "CHECK_BOX"},
    {name : 'address',
      label : 'Contact with address',
      type : 'String',
      formElement : "CHECK_BOX"}
  ]
  ,
  execute : function(request, callback) {
    var scope = 'https://www.google.com/m8/feeds';
    
    var contactsFeedUri = 'https://www.google.com/m8/feeds/contacts/default/full';
    var groupFeedUri    = 'https://www.google.com/m8/feeds/groups/default/full';
    /*var profilesFeedUri = 'https://www.google.com/m8/feeds/profiles/default/full';*/
    
    var MAX_RESULTS = 100;
        
    var myQuery = {};
    if(request.params['email'])      myQuery['email']      = true;
    if(request.params['phone'])      myQuery['phone']      = true;
    if(request.params['address'])    myQuery['address']    = true;
//        if(request.params['maxResults']) myQuery['maxResults'] = request.params['maxResults'];

    var contactsService = new google.gdata.contacts.ContactsService('Logica-MyCocktail_OmeletteProject-1.0');
    var token = google.accounts.user.checkLogin(scope);
    if (!token) {
        token = google.accounts.user.login(scope);
    } else {
        var handleError = function(e) {
            callback.onFailure({error   : (e.cause?e.cause.statusText:''), 
                                message : (e.message?e.message:'')});
        };
        
        var query = null;
        
        var searchBy = request.params['searchBy'] || 'Contacts';
        var searchPattern = request.params['searchPattern'];
        
        //CONTACTS
        if(searchBy == 'Contacts') {
            query = new google.gdata.contacts.ContactQuery(contactsFeedUri);
            query.setMaxResults(MAX_RESULTS);
            if(searchPattern) {
                query.setParam('q', searchPattern);
            }
            
            contactsService.getContactFeed(query, 
                function(result) {
                    var contacts = { contacts : googData.contactParser.contactsToJson(result.feed.entry, myQuery) };
                    if(afrous.editor) afrous.editor.Iconizer.addIconToProperty(contacts,'contacts','book');
                    callback.onSuccess(contacts);
                }, 
                handleError
            );
        } 
        // GROUPS
        else if(searchBy == 'Groups') {
            query = groupFeedUri;
            
            var groups = [];
            var groupReader = function(result) {
                var groupEntries = result.feed.entry;
                if (groupEntries.length > 0) {
                    var groupEntry = groupEntries.pop();
                    
                    var groupName = groupEntry.getTitle().getText();
                    if(!searchPattern || groupName.search(searchPattern) != -1) { 
                        var group = {};
                        group.name = groupName;
                        var groupId = groupEntry.getId().getValue();

                        var contactQuery = new google.gdata.contacts.ContactQuery(contactsFeedUri);
                        contactQuery.setMaxResults(MAX_RESULTS);
                        contactQuery.setParam('group', groupId);
                        
                        if(afrous.editor) {
                            afrous.editor.Iconizer.addIconToJson    (group,'group');
                            afrous.editor.Iconizer.addIconToProperty(group,'name','label');
                            afrous.editor.Iconizer.addIconToProperty(group,'contacts','book');
                        }

                        // Submit the request using the contacts service object
                        contactsService.getContactFeed(contactQuery, function(result) {
                            var contacts = googData.contactParser.contactsToJson(result.feed.entry, myQuery);
                            if(contacts.length > 0) {
                                group.contacts = contacts;
                                groups.push(group);
                            }
                            groupReader({feed : {entry : groupEntries}});
                        }, handleError);
                    } else {
                        groupReader({feed : {entry : groupEntries}});
                    }
                } else {
                    var g = {groups : groups};
                    if(afrous.editor) afrous.editor.Iconizer.addIconToProperty(g,'groups','group');
                    callback.onSuccess(g);
                }
            };
            
            contactsService.getContactGroupFeed(query, groupReader, handleError);
        } 
        // PROFILES
        /*else if(searchBy == 'Profiles') {
            query = new google.gdata.contacts.ProfileQuery(profilesFeedUri);
            query.setMaxResults(null);
            if(searchPattern) {
                query.setParam('q', searchPattern);
            }
            
            contactsService.getContactFeed(query, 
                function(result) {
                    var contacts = googData.contactParser.contactsToJson(result.feed.entry);
                    callback.onSuccess({contacts : contacts});
                }, 
                handleError
            );
        }*/
    }
  }
  

}));

googData.register(new afrous.UnitAction({
  type : 'calendardata',
  label : 'Calendar Search',
  iconCls : 'calendar-operator-uaction',
  description : 'Google Calendar Data API: This service returns all available calendars',
  inputs : [

  ]
  ,
  execute : function(request, callback) {
    var scope = 'https://www.google.com/calendar/feeds/';
    // The default "allcalendars" feed is used to retrieve a list of all
    // calendars (primary, secondary and subscribed) of the logged-in user
    var feedUri = 'https://www.google.com/calendar/feeds/default/allcalendars/full';

    var calendarService = new google.gdata.calendar.CalendarService('Logica-MyCocktail_OmeletteProject-1.0');

    if (!google.accounts.user.checkLogin(scope)) {
        var token = google.accounts.user.login(scope);
    } else {
        var handleError = function(e) {
            console.error("error: "+(e.cause?e.cause.statusText:'')+", message: "+(e.message?e.message:''));

            callback.onFailure({error   : (e.cause?e.cause.statusText:''),
                                message : (e.message?e.message:'')});
        };

        calendarService.getAllCalendarsFeed(feedUri,
            function(result) {
                var calendars =  { calendars : googData.calendarParser.calendarsToJson(result.feed.entry) };
                callback.onSuccess(calendars);
            },
            handleError
        );

    }
  }


}));

googData.register(new afrous.UnitAction({
  type : 'eventsdata',
  label : 'Event Search',
  iconCls : 'event-operator-uaction',
  description : 'Google Calendar Data API: This service returns all available events for a given calendar',
  inputs : [
    { name : 'calendarlink',
      label : 'Calendar link',
      type : 'String' },
    { name : 'fromTime',
      label : 'From',
      type : 'String' },
    { name : 'toTime',
      label : 'To',
      type : 'String' },
    { name : 'searchText',
      label : 'Search pattern',
      type : 'String' }
  ]
  ,
  execute : function(request, callback) {
    var scope = 'https://www.google.com/calendar/feeds/';
    // The default "" feed is used to retrieve a list of all
    // calendars (primary, secondary and subscribed) of the logged-in user
    var defaultFeedUri = 'https://www.google.com/calendar/feeds/default/private/full';
    var calendarlink = request.params['calendarlink'] || defaultFeedUri;
    var calendarService = new google.gdata.calendar.CalendarService('Logica-MyCocktail_OmeletteProject-1.0');

    // Create a CalendarEventQuery, and specify that this query is applied toward the calendarlink feed
    var query = new google.gdata.calendar.CalendarEventQuery(calendarlink);

    // Set the maximum number of results we want to receive
    query.setMaxResults(50);

    // Set the query with the query text
    var searchText = request.params['searchText'];
    if (searchText) query.setFullTextQuery(searchText);
    
    // Create and set the minimum start time for the date query.
    // By default is the current date.
    var fromTime = request.params['fromTime'];
    var startMin;
    if (fromTime){
        startMin = google.gdata.DateTime.fromIso8601(fromTime);
    }else{
        var auxDate= new Date();
        startMin = ""+auxDate.getFullYear()+"-"+(auxDate.getMonth()+1)+"-"+auxDate.getDate();

    }
    query.setMinimumStartTime(startMin);

    // Create and set the maximum end time for the date query
    // By default is three months after the current date.
    var toTime = request.params['toTime'];
    var endMax;
    if (toTime){
        endMax = google.gdata.DateTime.fromIso8601(toTime);

    }else{
        var auxDate= new Date();
        auxDate.setMonth(auxDate.getMonth()+3);
        endMax = ""+auxDate.getFullYear()+"-"+(auxDate.getMonth()+1)+"-"+auxDate.getDate();
    }
    query.setMaximumStartTime(endMax);


    if (!google.accounts.user.checkLogin(scope)) {
        var token = google.accounts.user.login(scope);
    } else {
        var handleError = function(e) {
            console.error("error: "+(e.cause?e.cause.statusText:'')+", message: "+(e.message?e.message:''));

            callback.onFailure({error   : (e.cause?e.cause.statusText:''),
                                message : (e.message?e.message:'')});
        };

        calendarService.getEventsFeed(query,
            function(result) {
                var events =  { events : googData.calendarParser.calendarEventsToJson(result.feed.entry) };
                callback.onSuccess(events);
            },
            handleError
        );

    }
  }


}));

afrous.packages.register(googData, 'google-data.js');


})();

