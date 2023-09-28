package com.account.jpaInheritance.controller.deserialize;

import com.account.jpaInheritance.model.entities.accounts.Accounts;
import com.account.jpaInheritance.model.entities.accounts.CurrentAccount;
import com.account.jpaInheritance.model.entities.accounts.SavingAccount;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class AccountDeserialize extends JsonDeserializer<Accounts> {

    @Override
    public Accounts deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException
    {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        Integer agency = Integer.parseInt(String.valueOf(jsonNode.get("agency")));
        Integer numberAccount = Integer.parseInt(String.valueOf(jsonNode.get("numberAccount")));
        Double balance = Double.parseDouble(String.valueOf(jsonNode.get("balance")));

        if(jsonNode.get("limit") != null)
        {
            Double limit = Double.parseDouble(String.valueOf(jsonNode.get("limit")));
            return new CurrentAccount(null, agency, numberAccount,
                    balance, null, limit);
        }

        return new SavingAccount(null, agency,numberAccount,balance, null);
    }
}
