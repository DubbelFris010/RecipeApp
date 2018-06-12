package com.angelo.moestadja.recipeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KottLand Lab on 6/16/2017.
 */

public final class MyGridAdapter extends BaseAdapter {

    private final List<Item>mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public String[] mRecipeTitle = {
            "Pancakes",
            "Pasta",
            "Lamb balti",
            "Tiramisu ",
            "Minestrone soup",



    };

    public  String[] mDescriptionTXT = {

            " \n" +
                    "Whisk flour, sugar, baking powder, baking soda, and salt in a large bowl. \n" +
                    "Whisk eggs, buttermilk, and butter in a medium bowl; stir into dry ingredients until just combined \n" +
                    "(some lumps are okay). Heat a griddle or large skillet over medium; brush with oil. Working in batches, \n" +
                    "scoop ⅓-cupfuls of batter onto griddle. Cook pancakes until bottoms are golden brown and bubbles form on top, \n" +
                    "about 3 minutes. Flip and cook until cooked through and other side of pancakes are golden brown, about 2 minutes \n" +
                    "longer. Serve pancakes with maple syrup.",
            "  Peel the onion, then finely chop with the carrot and celery. \n" +
                    "    Place a large pan on a medium-high heat with 2 tablespoons of olive oil and squeeze the sausagemeat out of the skins into the pan, breaking it up with a wooden spoon as you go. \n" +
                    "    Fry for a few minutes, then add the fennel seeds, oregano and chilli flakes, and strip in the rosemary. \n" +
                    "    Finely chop and add the basil stalks, reserving the leaves for later. \n" +
                    "    Add the chopped veg, then peel and finely grate in the garlic. \n" +
                    "    Cook for 10 minutes, or until softened. \n" +
                    "    Pour over the balsamic vinegar and leave to bubble away and reduce slightly. \n" +
                    "    Scrunch in the tomatoes through your clean hands, then add 1 tin’s worth of water and the larger basil leaves. \n" +
                    "    Bring to the boil, then simmer over a low heat for 20 minutes, or until thickened. \n" +
                    "    With around 10 minutes to go, cook the pasta in a pan of boiling salted water according to the packet instructions,then drain, reserving a mugful of cooking water. \n" +
                    "    Toss the drained pasta into the sausage pan, loosening with a little ved cooking water, if needed. \n" +
                    "    Taste and season to perfection, then remove from the heat.\n" +
                    "    Finely grate in the Parmesan, scatter over the remaining basil leaves, \n" +
                    "    and finish with a drizzle of extra virgin olive oil. \n" +
                    "    Delicious served with pinches of lemony rocket and an extra grating of Parmesan, if you like.",
            "Chop the lamb into rough 3cm chunks, then place in a bowl with the yoghurt, marinade spices and 1 teaspoon of salt, then mix well. \n" +
                    "    Cover and leave to marinate in the fridge for at least 2 hours, but preferably overnight.\n" +
                    "    For the sauce, toast the coriander and cumin seeds in a dry pan over a medium heat for 1 minute, then tip into a pestle and mortar and bash to a fine powder.\n" +
                    "    Add the chilli, turmeric, garam masala, cardamom pods and bay, then mix together. \n" +
                    "    Peel and finely grate the ginger, garlic and onions.\n" +
                    "    Drizzle 2 tablespoons of oil into a large frying pan over a medium heat, add the ginger and garlic, fry for 2 minutes, then add the onion and cook for a further 10 to 15 minutes, or until soft and golden.\n" +
                    "    Tip the tomatoes into the pan, breaking them up with your hands as you go, then stir in the spices and 500ml of boiling water. Simmer for 30 minutes, or until thickened and reduced, stirring occasionally.\n" +
                    "    Stir in the methi leaves, tamarind, honey and a pinch of sea salt, then remove from the heat.\n" +
                    "    Preheat the oven to 170ºC/325ºF/gas 3.\n" +
                    "    Drizzle 1 tablespoon of oil in a large frying pan over a medium heat, add the marinated lamb and fry for 5 minutes, or until browned all over – you may need to work in batches.\n" +
                    "    Add the lamb to the sauce, cover with a lid and place in the oven for 1 hour 30 minutes, or until the lamb is tender and the sauce is thickened, loosening with a splash of water, if needed.\n" +
                    "    Delicious served with fluffy rice, a scattering of coriander leaves and warm naan bread, if you like.",
            "To make a ganache, pour the cream into a pan and gently bring to a simmer over a medium heat.\n" +
                    "    Add a pinch of sea salt, snap in the chocolate and stir until melted, thickened and smooth, then remove from the heat and leave to one side.\n" +
                    "    Line a dish (20cm x 30cm) with the sponge fingers (or Genoese sponge, if you’ve made it), carefully pour over the hot sweetened coffee and drizzle over the Vin Santo or sweet sherry.\n" +
                    "    Spread the chocolate ganache over the top in an even layer.\n" +
                    "    In a food processor, blitz the ricotta, mascarpone, vanilla bean paste and honey until super-smooth. \n" +
                    "    Spoon this creamy mixture evenly on top of your chocolate layer.",
            "  Peel and finely chop the garlic and onion. Trim and roughly chop the carrots, celery and courgette, then add the vegetables to a large bowl.\n" +
                    "    Cut the ends off the leek, quarter it lengthways, wash it under running water, then cut into 1cm slices. Add to the bowl.\n" +
                    "    Scrub and dice the potato. \n" +
                    "    Drain the cannellini beans, then set aside.\n" +
                    "    Finely slice the bacon.\n" +
                    "    Heat 2 tablespoons of oil in a large saucepan over a medium heat. \n" +
                    "    Add the bacon and fry gently for 2 minutes, or until golden.\n" +
                    "    Add the garlic, onion, carrots, celery, courgette, leek, oregano and bay and cook slowly for about 15 minutes, or until the vegetables have softened, stirring occasionally.\n" +
                    "    Add the potato, cannellini beans and plum tomatoes, then pour in the vegetable stock. \n" +
                    "    Stir well, breaking up the tomatoes with the back of a spoon.\n" +
                    "    Cover with a lid and bring everything slowly to the boil, then simmer for about 30 minutes, or until the potato is cooked through. Meanwhile...\n" +
                    "    Remove and discard any tough stalks bits from the greens, then roughly chop.\n" +
                    "    Using a rolling pin, bash the pasta into pieces while it’s still in the packet or wrap in a clean tea towel.\n" +
                    "    To check the potato is cooked, pierce a chunk of it with a sharp knife – if it pierces easily, it’s done.\n" +
                    "    Add the greens and pasta to the pan, and cook for a further 10 minutes, or until the pasta is al dente. \n" +
                    "    This translates as ‘to the tooth’ and means that it should be soft enough to eat, but still have a bit of a bite and firmness to it. \n" +
                    "    Try some just before the time is up to make sure you cook it perfectly.",
    };

    public static final String[] Ingredients =

            {
                    " Ingredients  1⅓ cups all-purpose flour\n" +
                            "    3 tablespoons sugar\n" +
                            "    1 teaspoon baking powder\n" +
                            "    1 teaspoon baking soda\n" +
                            "    1 teaspoon kosher salt\n" +
                            "    2 large eggs\n" +
                            "    1¼ cups buttermilk\n" +
                            "    2 tablespoons unsalted butter, melted\n" +
                            "    Vegetable oil (for griddle)\n" +
                            "    Pure maple syrup (for serving)",
                    " 1 onion\n" +
                            "    1 carrot\n" +
                            "    1 stick of celery\n" +
                            "    olive oil\n" +
                            "    4 higher-welfare Italian sausages , (250g in total)\n" +
                            "    1 heaped teaspoon fennel seeds\n" +
                            "    1 teaspoon dried oregano , ideally the flowering kind\n" +
                            "    1 pinch of dried chilli flakes\n" +
                            "    1 sprig of fresh rosemary\n" +
                            "    1 bunch of fresh basil , (30g)\n" +
                            "    4 cloves of garlic\n" +
                            "    2 tablespoons balsamic vinegar\n" +
                            "    2 x 400 g tins of quality plum tomatoes\n" +
                            "    300 g dried penne\n" +
                            "    40 g Parmesan cheese , plus extra to serve\n" +
                            "    extra virgin olive oil",
                    " 1 kg lamb shoulder , bone out\n" +
                            "100 ml natural yoghurt\n" +
                            "1 tablespoon ground coriander\n" +
                            "1 teaspoon ground ginger\n" +
                            "1 teaspoon ground cumin\n" +
                            "1 teaspoon medium chilli powder\n" +
                            "1 teaspoon ground turmeric\n" +
                            "SAUCE\n" +
                            "2 teaspoons coriander seeds\n" +
                            "1 teaspoon cumin seeds\n" +
                            "½ teaspoon medium chilli powder\n" +
                            "½ teaspoon ground turmeric\n" +
                            "1 teaspoon garam masala\n" +
                            "4 green cardamom pods\n" +
                            "2 fresh bay leaves\n" +
                            "2 cm piece of ginger\n" +
                            "1 large clove of garlic\n" +
                            "3 onions\n" +
                            "vegetable oil\n" +
                            "1 x 400 g tin of quality plum tomatoes\n" +
                            "1 teaspoon dried methi leaves\n" +
                            "½ teaspoon tamarind paste\n" +
                            "½ teaspoon runny honey ",
                    "  200 ml double cream\n" +
                            "    100 g quality dark chocolate (70%) , plus extra to serve\n" +
                            "    100 g sponge fingers\n" +
                            "    150 ml good hot strong sweetened coffee\n" +
                            "    50 ml Vin Santo , or sweet sherry\n" +
                            "    500 g ricotta cheese\n" +
                            "    250 g mascarpone cheese\n" +
                            "    1 teaspoon vanilla bean paste\n" +
                            "    3 tablespoons runny honey\n" +
                            "    1 orange , or clementine",
                    "1 clove of garlic\n" +
                            "    1 red onion\n" +
                            "    2 carrots\n" +
                            "    2 sticks of celery\n" +
                            "    1 courgette\n" +
                            "    1 small leek\n" +
                            "    1 large potato\n" +
                            "    1 x 400 g tin of cannellini beans\n" +
                            "    2 rashers of higher-welfare smoked streaky bacon\n" +
                            "    olive oil\n" +
                            "    ½ teaspoon dried oregano\n" +
                            "    1 fresh bay leaf\n" +
                            "    2 x 400 g tins of plum tomatoes\n" +
                            "    1 litre organic vegetable stock\n" +
                            "    1 large seasonal greens, such as savoy cabbage, curly kale, chard\n" +
                            "    100 g wholemeal pasta\n" +
                            "    ½ a bunch of fresh basil , optional\n" +
                            "    Parmesan cheese",
            };



    // Keep all Images in array
    public Integer[] mThumbIds = {


            R.drawable.pancakes_receipt, R.drawable.pasta_recipe, R.drawable.health_food, R.drawable.healthy_food2,
            R.drawable.recipe,


    };


    public MyGridAdapter(Context context){
        mInflater = LayoutInflater.from(context);



        mItems.add(new Item("Pancakes", R.drawable.pancakes_receipt ) );  mItems.add(new Item("Pasta", R.drawable.pasta_recipe ) );
        mItems.add(new Item("Lamb balti", R.drawable.health_food ) );  mItems.add(new Item("Tiramisu", R.drawable.healthy_food2 ) );
        mItems.add(new Item("Minestrone soup", R.drawable.recipe ) );



    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return mItems.get(i).drawableId;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        ImageView picture;
        TextView name;
        if (v==null){

            v= mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text,v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);
        Item item = getItem(i);
        picture.setImageResource(item.drawableId);
        name.setText(item.name);
        return v;

    }

    private static class Item {
        public final String name;
        public final  int  drawableId;
        Item(String name, int drawableId){
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}
