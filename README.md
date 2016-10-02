# Experimental Architecture Marvel #

![](https://bytebucket.org/narfss/arduino-bluetooth-y-android/raw/83274506ceaea69a216e1b9e071e18e2552d3eb7/arduiblueandr.png?token=4f67415d32a567a569ec479758abecdae5a16b9d)

This repository is an example of architecture and use of some techniques related with android development.

This example is a basic app that get data from Marvel api.
The behaviour is to list the characters.
From the list can be added to a favourite in order to access to the comics related with the character.
Last view is the comic details showing title, description and images.

### Content ###

* Clean architecture: The project architecture is an implementation of clean architecture.
* Injection: Objects in some class constructors are injected with Dagger.
* Api access: The access to the marvel api is done with Retrofit2
* Database: The favourite characters are saved in a mysql database.
* Custom views: Characters avatar and comic animated background are custom widgets.
* Unit testing: "Use cases" and objects with logic are tested.
* Instrumentation testing: Basic test of adding favourite and access to a comic.

Any feedback is welcome.

Thanks.

## License

Copyright Francisco M Sirvent 2016 (@narfss)

This file is part of some open source application.

Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.

Contact: Francisco M Sirvent <narfss@gmail.com>