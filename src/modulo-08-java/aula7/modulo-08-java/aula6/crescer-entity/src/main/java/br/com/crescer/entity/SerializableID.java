/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import java.io.Serializable;

/**
 *
 * @author Diuly
 *  @param <ID>
 */
public abstract class SerializableID<ID extends Serializable> implements Serializable {
    public abstract ID getId();
}
