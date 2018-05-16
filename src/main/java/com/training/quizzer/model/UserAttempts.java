package com.training.quizzer.model;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.training.quizzer.service.LocalDateTimeAttributeConverter;

@Entity
public class UserAttempts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // id
	private Long userId; // user_id
	private Integer attempts; // attempts
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime lastmodified; // lastmodified
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime firstattempt; // firstattempt

	public UserAttempts() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public LocalDateTime getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(LocalDateTime lastmodified) {
		this.lastmodified = lastmodified;
	}

	public LocalDateTime getFirstattempt() {
		return firstattempt;
	}

	public void setFirstattempt(LocalDateTime firstattempt) {
		this.firstattempt = firstattempt;
	}

	@Override
	public String toString() {
		return "UserAttempts [id=" + id + ", userId=" + userId + ", attempts=" + attempts + ", lastmodified="
				+ lastmodified + ", firstattempt=" + firstattempt + "]";
	}

}
