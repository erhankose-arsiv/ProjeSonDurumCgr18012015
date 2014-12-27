
package org.tutev.cagri.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getIncidentByNo", namespace = "incident.tutev.org")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getIncidentByNo", namespace = "incident.tutev.org", propOrder = {
    "incidentNo",
    "username",
    "password"
})
public class GetCagriByNo {

    @XmlElement(name = "incidentNo", namespace = "")
    private String incidentNo;
    @XmlElement(name = "username", namespace = "")
    private String username;
    @XmlElement(name = "password", namespace = "")
    private String password;

    /**
     * 
     * @return
     *     returns String
     */
    public String getIncidentNo() {
        return this.incidentNo;
    }

    /**
     * 
     * @param incidentNo
     *     the value for the incidentNo property
     */
    public void setIncidentNo(String incidentNo) {
        this.incidentNo = incidentNo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 
     * @param username
     *     the value for the username property
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * @param password
     *     the value for the password property
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
