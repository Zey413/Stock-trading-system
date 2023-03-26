package com.itranswarp.exchange.model.quotation;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.itranswarp.exchange.model.support.AbstractBarEntity;

/**
 * Store bars of minute.
 */
@Entity
@Table(name = "min_bars")
public class MinBarEntity extends AbstractBarEntity {

}
