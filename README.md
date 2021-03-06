pcs_api
=======

Personal Cloud Storages API: a library that abstract providers and gives a uniform API
to several personal cloud storages providers.
As of today, the following providers are supported:
[Dropbox](https://www.dropbox.com),
[hubiC](https://hubic.com),
[Google Drive](http://www.google.com/drive/),
[CloudMe](https://www.cloudme.com).

API provides the following methods:

- list/create/delete folder
- upload/download/delete blob (a blob is a regular file)
- inquire about user and about used/available storage quota.

pcs_api is released under Apache License V2.0


Languages
---------

The API has been developped in many languages (Java, android, Python and C++).
Some samples are availables in the `samples` directory for each one.

### Java and android
An implementation exists for Java (1.6+). It is also compliant with android API 8+.
The base library uses a maven artefact with the following dependencies:

- *httpclient* for the network access (already provided on android platform)
- *json* to parse the JSON server responses (already provided on android platform)
- *slf4j* for the logging

The unit tests are done using the *JUnit4* library (JUnit3 on android).

[Android Studio](http://developer.android.com/sdk/installing/studio.html) has been used to build the android library.
It generates an archives `aar` which can be used in an application. This works as a Maven artefact.

**WARNING:** the *aar* file can only be used with *Android Studio* ; it is not compatible with *Eclipse*.

### Python
An implementation exists for Python (tested on version 2.7), available as [a pypi package](https://pypi.python.org/pypi/pcs-api).

Python implementation has some dependencies, as specified in [setup.py](python/setup.py)
(*pip* and *virtualenv* are recommended for installation).
Basically, *requests* and *requests-oauthlib* are used for http requests and OAuth authentication,
*pytest* is used for testing.

### C++
An implementation exists for C++11 (tested on MSVC 2013 and gcc-4.8).

C++ implementation depends on Microsoft `cpprestsdk` for http requests (aka Casablanca: https://casablanca.codeplex.com),
and `boost` libraries (v1.55).
`googletest` is used for testing (included in repository as a git submodule: cpp/third_party/gtest).
Build is based on `cmake` (tested with cmake 2.8.12).
`pcs_api` has been tested on Windows (desktop, non mobile) and Linux. Due to limitations in cpprestsdk,
CloudMe provider is not available for non Windows platforms.


Getting started
---------------
See this [page](docs/getting_started.md).

Build
-----
See this [page](docs/build.md)

Features
--------
pcs_api can handle several authentications types:

- [OAuth2](docs/oauth2.md) (used by Dropbox, hubiC, Google Drive)
- Login / password (CloudMe uses http digest authentication)

Each provider has its specificity that are described [here](docs/provider_specifics.md);

The stream on files are wrapped by the same objects whatever the choosen provider.
To download a file (blob) from provider the `ByteSink` interface must be used and to upload some data,
the `ByteSource` interface must be used.
More informations are available [here](docs/byte_sources_and_sinks.md);

For more technical informations, please read this [page](docs/advanced.md).

Support
-------
Please fill a github issue to report any problem or enhancement request.

Contributors are welcome.

