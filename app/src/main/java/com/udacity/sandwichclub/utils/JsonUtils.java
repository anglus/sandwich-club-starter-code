package com.udacity.sandwichclub.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.udacity.sandwichclub.model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject name = jsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");

            List<String> alsoKnownAs = new ArrayList<>();
            JSONArray akaArray = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < akaArray.length(); i++) {
                alsoKnownAs.add(akaArray.getString(i));
            }

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");

            List<String> ingredients = new ArrayList<>();
            JSONArray ingArray = jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < ingArray.length(); i++) {
                ingredients.add(ingArray.getString(i));
            }

            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredients);

            return sandwich;
        } catch (JSONException e) {
            Log.e("JSON parsing error", e.getMessage());
        }
        return null;
    }
}
