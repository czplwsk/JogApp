package com.example.jogapp

class Trail private constructor(val name: String, val imageResourceId: Int, val description: String) {

    companion object {
        val trails = arrayOf(
            Trail("Trail 1", R.drawable.gory, "From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Continue on Old Baldy Trail past Bellows Spring to Baldy Saddle.  There are 32 switchbacks between the Spring and Saddle.  Return by the same route."),
            Trail("Trail 2", R.drawable.gory, "From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Continue on Old Baldy Trail past Bellows Spring to Baldy Saddle.  There are 32 switchbacks between the Spring and Saddle.  Return by the same route."),
            Trail("Trail 3", R.drawable.gory, "From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Continue on Old Baldy Trail past Bellows Spring to Baldy Saddle.  There are 32 switchbacks between the Spring and Saddle.  Return by the same route."),
            Trail("Trail 4", R.drawable.gory, "From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Continue on Old Baldy Trail past Bellows Spring to Baldy Saddle.  There are 32 switchbacks between the Spring and Saddle.  Return by the same route."),
            Trail("Trail 5", R.drawable.gory, "From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Continue on Old Baldy Trail past Bellows Spring to Baldy Saddle.  There are 32 switchbacks between the Spring and Saddle.  Return by the same route."),
            Trail("Trail 6", R.drawable.gory, "From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Continue on Old Baldy Trail past Bellows Spring to Baldy Saddle.  There are 32 switchbacks between the Spring and Saddle.  Return by the same route.")
        )
    }
}