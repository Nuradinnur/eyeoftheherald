# Eye of the Herald

A battle-tested, fully-functional, open sourced backend for developers wishing to play with the Riot Games API for the smash-hit video game League of Legends.

Consider it an abstraction layer (with lots of extra features) for the API.

#### Why should I use this as my backend?
The League of Legends API has many, many strangely labelled properties in the DTOs, can have very complex object structures and is generally an annoyance to use. Because of the strict rate limiting they enforce (and the impossibility of syncing clocks with Riot's servers), it is needlessly difficult to simply pull data from the API for hobbyist developers.  

Eye of the Herald (EotH) will provide a one-stop-shop API wrapper and/or endpoints, written in Java and Spring.  From rate limiting to producing clean and ready to use objects, it aims to be a very extendable and very secure foundation for your stack.

It also comes with persistence, a crawling algorithm (with customization coming in the future) and Data Dragon support.

Currently, there is a lot of work to be done, and many things are broken, but expect frequent updates.  At the rate the project has been progressing, there should be significant work done by February or so.  By then, the application should be production ready and secure.

**Note:** you don't have to be a Java developer to make use of this application!  Once the core components are complete, developers can customize the behaviour of the application via configuration files, run the application and simply call its endpoints *in any language they wish*.

---

#### Current features:
* Data Dragon (static game data) support
* Wrapped, easy-to-use API access
    * DTOs retrieved from the Riot Games API
    * Rate limiting (Using a modified version of the [Token Bucket algorithm](https://en.wikipedia.org/wiki/Token_bucket))
* Basic crawling algorithm 
    
#### Upcoming features:
* Persistence
    * Immutability in entity objects (Objects represent game state and should *not* change)
    * DTO-to-persistent-entity converters (mappers)
    * Caching of frequently pulled data
    * Spring repositories
    * Spring queries to provide insightful statistics, i.e.: *Morgana, in winning matches, averages a KDA of 5.7 / 2.9 / 12.6*
* Customizability
    * Crawler algorithm strategies, speeds, persistence/transience, et cetera
    * Caching strategies used
    * Central configuration file
* Security
    * Limit all controller requests to specific hosts
    * API key security (A necessary requirement in obtaining a production API key)
* Want more?
    * Feel free to leave an issue or pull request if you want to contribute your ideas!
    
---

#### Backend architecture

A lot of thought has been put into the application architecture.  The data pipeline has been carefully designed so as to provide:

1. Removal of defunct properties and data types
2. Clean and readily recognizable objects and child properties
3. Integration with static Data Dragon definitions and images
4. Persistence, abstracted from the rest of the application
5. Efficient rate limiting per region
6. Performance, both computationally and memory-wise

A flow chart, below, depicts each major step in the data pipeline during an example scenario.

##### A request is made for a particular summoner's match history
The request is echoed down to the Data Interface.  The interface requests the Rate Limiter for permission to execute the request.  If the rate limiter declines, the request can either sleep until the rate limiter grants the request, or the request can fail returning an informational `429 Too Many Requests` response.  This strategy will be configurable.

`Riot API <------ Rate Limiter <------ Data Interface <------ Service <------ Request`

##### The Riot API responds with some JSON
The API returns JSON, which is then mapped to a persistent object.  The object has clean properties with simple and accurate names, and static data types such as `Champions` or `SummonerSpells` are injected.  The objects are then optionally persisted and future requests for the same data (within certain conditions) will be retrieved from the database.  The object is handed back to the service.

`Riot API ------> Data Interface ------> Service <------> Object Mapper / Data Dragon Service`

##### Optional: transformative operations on the objects
In most cases, for example a summoner lookup application, the backend controllers need to provide output composed of data from multiple Riot API endpoints.  Since the data returned is very verbose, optional processing of the data will need to be done so that a user of the application does not download 8 megabytes of JSON per request.  Multiple transformation layers might be required.

`Service ------> 1-N Transformation Layers ------> Controllers`
