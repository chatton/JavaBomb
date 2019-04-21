package com.chatton.javabomb.api.client.requestbuilders;

import com.sun.tools.javac.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryBuilder {
    private final String base;
    private final List<Pair<String, String>> fields;

    QueryBuilder(final String base) {
        this(base, Collections.singletonList(new Pair<>("format", "json")));
    }

    QueryBuilder(final String base, final List<Pair<String, String>> fields) {
        this.base = base;
        this.fields = new ArrayList<>(fields);
    }

    QueryBuilder addField(final String key, final Object param) {
        if(param != null){
            this.fields.add(new Pair<>(key, param.toString()));
        }
        return this;
    }

    String build(){
        boolean first = true;
        final StringBuilder sb = new StringBuilder(base);
        for(Pair p : fields){
            if(first){
                sb.append("?");
                first = false;
            } else {
                sb.append("&");
            }
            sb.append(p.fst).append("=").append(p.snd);
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return build();
    }
}
