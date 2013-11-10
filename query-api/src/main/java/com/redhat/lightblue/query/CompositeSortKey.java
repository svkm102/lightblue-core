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
package com.redhat.lightblue.query;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CompositeSortKey extends Sort {

    private List<SortKey> keys;

    public CompositeSortKey() {}

    public CompositeSortKey(List<SortKey> keys) {
        this.keys=keys;
    }

    public CompositeSortKey(SortKey... k) {
        this(Arrays.asList(k));
    }

    public List<SortKey> getKeys() {
        return keys;
    }

    public void setKeys(List<SortKey> keys) {
        this.keys=keys;
    }

    public JsonNode toJson() {
        ArrayNode arr=factory.arrayNode();
        for(SortKey x:keys)
            arr.add(x.toJson());
        return arr;
    }

    public static CompositeSortKey fromJson(ArrayNode node) {
        ArrayList<SortKey> l=new ArrayList<SortKey>(node.size());
        for(Iterator<JsonNode> itr=node.elements();
            itr.hasNext();)
            l.add(SortKey.fromJson((ObjectNode)itr.next()));
        return new CompositeSortKey(l);
    }
}
