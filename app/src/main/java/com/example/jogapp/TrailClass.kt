package com.example.jogapp

data class TrailClass (
    var title: String,
    var body: String,
    var bestScore: Int,
    var lastScore: Int
){
    override fun toString(): String {
        return title
    }


}

val trail1 = TrailClass("Baldy Saddle","From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Continue on Old Baldy Trail past Bellows Spring to Baldy Saddle.  There are 32 switchbacks between the Spring and Saddle.  Return by the same route.", 0, 0)
val trail2 = TrailClass("Carrie Nation Mine","From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn right and follow Vault Mine Trail about 0.5 mile to a second trail junction.  Follow Carrie Nation Trail to the left and up to an abandoned mine.  Return by the same route.", 0, 0)
val trail3 = TrailClass("Crest Trail Crossover","Proceed to Baldy Saddle (see above), turn left and follow Crest Trail to Florida Saddle.  A side trip to Armour Spring adds 0.8 mile.  Follow Florida Canyon Trail to a parking area at the USDA Experimental Station.  A shuttle car is needed for the return to the starting point.",0, 0)
val trail4 = TrailClass("Josephine Canyon","From the SE trailhead go south 0.3 mile to a signed trail intersection.  Turn left and follow rocky Old Baldy Trail to Josephine Saddle.  Cross the saddle and follow trail south down into Josephine Canyon for about 2.5 miles to the remains of an old stone building.  Return by same route.", 0, 0)
val trail5 = TrailClass("Josephine Saddle Loop","From the NE trailhead follow Super Trail 3.7 miles to Josephine Saddle.  Return to Mt Wrightson Picnic Area by following Old Baldy Trail 2.2 miles to a signed trail intersection.  Turn right.",0, 0)
val trail6 = TrailClass("Bog Springs","This hike can be started at either of two trailheads on the east side of the main road, as shown on Maps B and C.  From the trailhead on B follow trail 0.6 mile to sign on a former jeep road, turn right and proceed to trail intersection with Kent Spring Trail.  Turn left and go to Bog Springs.From the trailhead on C follow trail 0.4 mile to sign at intersection with trail coming from B.  Proceed straight ahead to trail intersection with Kent Spring Trail.  Turn left and go to Bog Springs.",0, 0)
val trails = mutableListOf(trail1, trail2, trail3, trail4, trail5, trail6)

