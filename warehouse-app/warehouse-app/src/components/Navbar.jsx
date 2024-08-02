import React from 'react'
import hummel from '../assets/hummel.png'
import { Link, NavLink } from 'react-router-dom'

{/** The implementation of the navigation bar */}
export default function NavBar() {
    
    {/** It includes the company logo and links to the main pages of the warhouse management system */}
    return (<>
        <nav className='nav'>
            <img src={hummel} alt='Hummel' width={'150'}></img>
            <ul>
                <li className='active'><Link to = '/'>Warehouses</Link></li>
                <li className='active'><Link to = '/products'>Products</Link></li>
                <li className='active'><Link to = '/inventory'>Inventory</Link></li>
            </ul>
        </nav>

    </>)
}

