/*
 * Copyright 2010 José María Jiménez Torrejón (jmjimenezt--at--grupogesfor.com)
 * Informática Gesfor
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

package com.germinus.ecm.bean;

import java.util.List;
import javax.xml.namespace.QName;
import net.sf.json.JSONObject;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Entry;

public class AtomToJSON {

	public AtomToJSON() {
	}
	
	public JSONObject feed2JSON(Feed feed) {
		JSONObject json = new JSONObject();
		
		List<Element> list = feed.getElements();
		json = this.list2json(list, json);
		
		return json;
	}
	
	public JSONObject entry2JSON(Entry entry) {
		JSONObject json = new JSONObject();
		
		List<Element> list = entry.getElements();
		json = this.list2json(list, json);
		
		return json;
	}
	
	
	private JSONObject list2json(List<Element> l, JSONObject json) {
		
		for (int i=0; i<l.size(); i++) {
			Element e = l.get(i);
			List<Element> subl = e.getElements();
			QName qname = e.getQName();
			if (subl.size()==0) {
				String tag = qname.getLocalPart();
				if (json.containsKey(tag)) {
					json.accumulate(tag, e.getText());
				} else {
					json.put(tag, e.getText());
				}
			} else {
				JSONObject aux = new JSONObject();
				String tag = qname.getLocalPart();
				if (json.containsKey(tag)) {
					json.accumulate(tag, list2json(subl, aux));
				} else {
					json.put(tag, list2json(subl, aux));
				}
			}
		}
		return json;
	}
}
