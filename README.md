# stentle-project

## API 1
* Endpoint: h ttp://localhost/ex­1/alumni
* HTTP method: POST
* Headers: 
    * Content­Type: application/json 
    * RequestBody:
        {
        “name”:”nome”;
        “addresses”:[
        { “street”:”streetname”, “number”:”22”, “country”:”country”},
        { “street”:”streetname2”, “number”:”33”, “country”:”country”}
        ],
        “education”:{“master”:{“university”:”Politecnico Milano”, year: 2004}, “phd”:{“university”:”UCSD”, year: 2009}}
        }

API 1 saves the payload on a local DB and:
* validate the payload so that only completed address are accepted
* validate the payload so that the street number of each address contains numbers only
* validate the payload so that the name contains letters only
   
## API 2
* Endpoint: http://localhost/ex­1/alumni
* Request Parameters:
    * name (optional): the name
    * education (optional): the education level (master/phd)
    * page (optional): the page index
    * size (optional): the page size
* HTTP method: GET
* Headers: 
    * Content­Type: application/json
    * Response Body:
    {
    “totalCount”: [total number of records]
    "totalPages": [total number of pages]
    "page": [the current page index]
    “data:”[the list of elements found] 
    }
    
API 2 allows to retrieve the alumni already stored. Results are paged. If no input parameters are
given, the API returns all the alumni stored with default paging parameters (page=0, size=20).