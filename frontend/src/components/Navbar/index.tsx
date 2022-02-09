import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import "./styles.css";

function Navbar() {
    return (
      <header>
        <nav className="container">
          <div className="havagas-nav-content">
            <h1>Há Vagas!</h1>
            <a href="https://github.com/DiSousaDev">
              <div className="havagas-contact-container">
                <GithubIcon />
                <p className="havagas-contact-link">/DiSousaDev</p>
              </div>
            </a>
          </div>
        </nav>
      </header>
    );
  }
  
  export default Navbar;