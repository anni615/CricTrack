//import logo from './logo.svg';
import './App.scss';
import {BrowserRouter ,Routes, Route} from 'react-router-dom';
import { TeamPage } from './pages/TeamPage';
import { MatchPage } from './pages/MatchPage';
import {HomePage} from './pages/HomePage';
function App() {
  return (
    <BrowserRouter>
    <div className="App">
      
      <Routes>
      {/* <Switch> */}
      <Route path="teams/:teamName/matches/:year"element={<MatchPage/>}/>
      {/* <MatchPage/> */}
      {/* </Route> */}
        <Route path="/teams/:teamName" element={<TeamPage/>}/>
        <Route path="/team" element={<HomePage/>}/>
          {/* <HomePage/>
        </Route> */}
        {/* <TeamPage/> */}
        {/* </Route>  */}
        {/* </Switch> */}
      
      </Routes>
       
    </div>
    </BrowserRouter>
  );
}

export default App;
