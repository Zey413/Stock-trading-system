package com.itranswarp.exchange.model.quotation;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.itranswarp.exchange.model.support.AbstractBarEntity;

/**
 * Store bars of second.
 */
@Entity
@Table(name = "sec_bars")
public class SecBarEntity extends AbstractBarEntity {

}
