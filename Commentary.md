#Commentary

##Refactor with common
* When beginning to add Shape Renderer Sample it became obvious that because I re-wrote the sampler program as a
console app (because JFrame is not available in libGDX 3) I am missing the common files that were created to make the sampler run
in particular SampleBase. So, here I go back and add all of these and refactor the console app.