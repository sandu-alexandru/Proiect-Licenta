package com.training.quizzer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by alexandru.sandu
 */

@Entity // This tells Hibernate to make a table out of this class
public class User {
	public enum Role {
		ADMIN("ADMIN"), USER("USER"); 
		
		private final String value; 
		
		private Role(String value) { 
			this.value = value; 
		}
		
		public String toString() {
			return this.value;
		}
	}
	
	public enum Status{
		ACTIVE("ACTIVE"), INACTIVE("INACTIVE");
		
		private final String value; 
		
		private Status(String value) { 
			this.value = value; 
		}
		
		public String toString() {
			return this.value;
		}
	}

//    public enum Domain{
//        BIOLOGY("BIOLOGY"), HISTORY("HISTORY"), GEOGRAPHY("GEOGRAPHY");
//
//        private final String value;
//
//        private Domain(String value) {
//            this.value = value;
//        }
//
//        public String toString() {
//            return this.value;
//        }
//    }

    public enum First{
        YES("YES"), NO("NO");

        private final String value;

        private First(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;
    
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "domain")
    private String domain;
//    @Enumerated(EnumType.STRING)
//    private Domain domain;

    @Column(name = "first")
    @Enumerated(EnumType.STRING)
    private First first;

    @Column(name = "last1")
    private String last1;

    @Column(name = "last2")
    private String last2;

    @Column(name = "last3")
    private String last3;

    @Column(name = "currlevel")
    private String currentLevel;
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Role getRole() {
    	return role;
    }
    
    public void setRole(Role role){
    	this.role = role;
    }
    
    public Status getStatus() {
    	return status;
    }
    
    public void setStatus(Status status) {
    	this.status = status;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    //    public void  setDomain(Domain domain) {this.domain = domain;}

    public void  setFirst(First first) {this.first = first;}

//    public Domain getDomain() {return domain;}

    public String getDomain(){return domain;}

    public First getFirst() {
        return first;
    }

    public String getLast1() {
        return last1;
    }

    public String getLast2() {
        return last2;
    }

    public String getLast3() {
        return last3;
    }

    public void setLast1(String last1) {
        this.last1 = last1;
    }

    public void setLast2(String last2) {
        this.last2 = last2;
    }

    public void setLast3(String last3) {
        this.last3 = last3;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role +
                ", status=" + status + ", domain=" + domain + ", first=" + first + "]";
	}
}
