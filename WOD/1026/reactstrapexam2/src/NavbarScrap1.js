import { useState } from 'react';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
    NavLink
} from 'reactstrap';


function NavbarScrap1(){

    const [ open, setOpen] = useState(false);
    const toggle = () => {
        setOpen(!open);
    }

    return(
        <div style={{width:"800px"}}>
            <Navbar color="light" light className="mr-auto" expand="md">
                <NavbarBrand href="https://edu.kosta.or.kr" className="mr-auto"><b><i>kosta</i></b></NavbarBrand>
                <NavbarToggler onClick={toggle}/>
                <Collapse isOpen={open} navbar>
                    <Nav navbar className="ml-auto">
                        <NavItem>
                            <NavLink href="http://naver.com">네이버</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink href="http://daum.net">다음</NavLink>
                        </NavItem>
                        <UncontrolledDropdown nav inNavbar>
                            <DropdownToggle nav caret>
                                Options
                            </DropdownToggle>
                            <DropdownMenu>
                                <DropdownItem>Option 1</DropdownItem>
                                <DropdownItem>Option 2</DropdownItem>
                                <DropdownItem>Option 3</DropdownItem>
                            </DropdownMenu>
                        </UncontrolledDropdown>
                    </Nav>
                </Collapse>

            </Navbar>
        </div>
    )
}

export default NavbarScrap1;