package com.itranswarp.exchange.model.quotation;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.itranswarp.exchange.model.support.AbstractBarEntity;

/**
 * Store bars of hour.
 */
@Entity
@Table(name = "hour_bars")
public class HourBarEntity extends AbstractBarEntity {

}
