/*
    Copyright 2013 Red Hat, Inc. and/or its affiliates.

    This file is part of lightblue.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.redhat.lightblue.metadata.constraints;

import java.io.Serializable;

import com.redhat.lightblue.metadata.Type;

import com.redhat.lightblue.metadata.types.ArrayType;

/**
 * Array min/max size  constraints
 */
public class ArraySizeConstraint extends AbstractIntFieldConstraint {

    public static final String MIN="minItems";
    public static final String MAX="maxItems";

    public ArraySizeConstraint(String type) {
        super(type);
    }

    @Override
    public boolean isValidForFieldType(Type fieldType) {
        return ArrayType.TYPE.equals(fieldType);
    }
}
