import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  const [movies, setMovies] = React.useState([]);
  React.useEffect(() => {
    fetch('http://localhost:4000/', {
      method: 'POST',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify({
        query: `query ExampleQuery {
          movies(options:{limit:10}) {
            title
            actors{
              name
            }
          }
        }`
      })
    })
      .then(res => res.json())
      .then(res => {
        setMovies(res.data.movies);
      })
      .catch(console.error);
  }, []);
  return (
    <div className="container">
      <div className='display-1'>Neoflix</div>
      <hr />
      <div className='display-4'>Movies</div>
      <hr />
      <div className='row'>
        {movies.map((movie, index) => (
          <div key={index} className='col-3'>
            <div className='card'>
              <div className='card-body'>
                <div className='display-3'>{movie.title}</div>
                <ul >
                  {movies[index].actors.map((actor, index) => (
                    <li className='list-group-item' key={index}>{actor.name}</li>
                  ))}
                </ul>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
