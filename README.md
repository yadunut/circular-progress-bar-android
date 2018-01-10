# Circular Progress Bar for Android

Inspired from [lzyzsd/CircleProgress](https://github.com/lzyzsd/CircleProgress)

A circular / Donut Progress Bar for Android written using Kotlin

Now with Rings!

![Progress bar](raw.githubusercontent.com/yadunut/circular-progress-bar-android/master/demos/progressbar.gif)

## Getting Started
No other dependencies. 
### Installation

####Step 1: 
Add this to your root build.gradle at the end of repositories
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
####Step 2
Add the dependency
```groovy
	dependencies {
		compile 'com.github.yadunut:circular-progress-bar-android:0.3.0'
	}
```
## Usage
#### Attributes
```xml
    <declare-styleable name="CircleProgress">
        <attr name="circle_finished_color" format="color"/>
        <attr name="circle_unfinished_color" format="color"/>
        <attr name="circle_inner_color" format="color"/>
        <attr name="circle_ring_color" format="color"/>

        <attr name="circle_finished_width" format="dimension"/>
        <attr name="circle_unfinished_width" format="dimension"/>
        <attr name="circle_ring_width" format="dimension"/>

        <attr name="circle_progress" format="float"/>
        <attr name="circle_progress_max" format="float"/>
        <attr name="circle_start_angle" format="float"/>

        <attr name="circle_show_text" format="boolean"/>
        <attr name="circle_text" format="string"/>
        <attr name="circle_text_color" format="color"/>
        <attr name="circle_text_size" format="dimension"/>
    </declare-styleable>
```


## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc

