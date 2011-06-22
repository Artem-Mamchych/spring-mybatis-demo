/**
 * Copyright (C) 2011  jtalks.org Team
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * Also add information on how to contact you by electronic and paper mail.
 * Creation date: Apr 12, 2011 / 8:05:19 PM
 * The jtalks.org Project
 */
package com.ss.demo.services.transactional;

import com.ss.demo.model.Dao;
import com.ss.demo.model.entity.Persistent;
import com.ss.demo.services.EntityService;
import com.ss.demo.services.exceptions.NotFoundException;

import java.util.List;

/**
 * Generic implementation of all entity based services.
 * Most of the implementations of the methods are basing on straightforward calls
 * of the same named method from DAO interface.
 *
 * @author Osadchuck Eugeny
 * @author Kirill Afonin
 */
public abstract class AbstractTransactionalEntityService<T extends Persistent, Y extends Dao>
        implements EntityService<T> {
    /**
     * Dao object implementation.
     */
    protected Y dao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!dao.isExist(id)) {
            throw new NotFoundException("Entity with id: " + id + " not found");
        }
        dao.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(Integer id) throws NotFoundException {
        if (!dao.isExist(id)) {
            throw new NotFoundException("Entity with id: " + id + " not found");
        }
        return (T) dao.get(id);
    }
}
