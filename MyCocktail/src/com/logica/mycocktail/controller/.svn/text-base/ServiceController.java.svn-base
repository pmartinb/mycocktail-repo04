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
package com.logica.mycocktail.controller;

import com.germinus.mashupbuilder.bean.Mashup;
import com.germinus.mashupbuilder.controller.Errors;
import com.germinus.mashupbuilder.dao.DAOException;
import com.germinus.mashupbuilder.dao.factory.DAOFactory;
import com.germinus.mashupbuilder.dao.jdbc.MashupDAO;
import com.logica.mycocktail.ssjs.MyCocktailMashupServerExecutor;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a controller of the mashup execution as services.
 * @author David del Pozo González
 */
public class ServiceController {
    private MyCocktailMashupServerExecutor mmse;
    
    private static ServiceController sc;
    
    private ServiceController(String myCocktailURLPath) 
        throws MalformedURLException {

        mmse = new MyCocktailMashupServerExecutor(myCocktailURLPath);
    }
    
    /**
     * Retunas an instance of ServiceController
     * @param myCocktailURLPath the path where MyCocktail is deployed
     * @return an instance of ServiceController
     * @throws MalformedURLException 
     */
    public static synchronized ServiceController getInstance(String myCocktailURLPath) 
        throws MalformedURLException {
        
        if (sc == null) {
            sc = new ServiceController(myCocktailURLPath);
        }
        return sc;
    }
    
    /**
     * This method execute a mashup as a REST service.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      id: the id of the mashup to retrieve.
     *   </li>
     * </ul>
     */
    public String executeMashup(int mashupId, Map<String,String> parametersMap) {

        try {
            Mashup mashupPattern = new Mashup();
            mashupPattern.setId(mashupId);

            DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.FactoryType.JDBC);
            MashupDAO mashupDAO = (MashupDAO) daoFactory.getDAO(Mashup.class);
            Mashup mashupFound = mashupDAO.find(mashupPattern);
            if (mashupFound != null) {
               String result = mmse.executeMashup(mashupFound.getJson(), parametersMap);
               result = "{result:" + result + "}";
               return result;
            } else {
                return reportError(Errors.MASHUP_NOT_FOUND);
            }
        } catch (NumberFormatException nbe) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.WARNING, null, nbe);
            return reportError(Errors.INSUFICIENTS_PARAMETERS);
        } catch (DAOException ex) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            return reportError(Errors.DATABASE_ERROR);
        } catch (Exception ex) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            return reportError(Errors.UNKNOWN_ERROR);
        }
    }

    /**
     * Returns an error in json format.
     */
    private String reportError(final String error) {
        return "{ error : " + error + "}";
    }
}
