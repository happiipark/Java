import {InputGroup, InputGroupAddon, InputGroupText, Input, InputGroupButtonDropdown, DropdownToggle, DropdownItem, DropdownMenu} from 'reactstrap';
import { useState } from 'react';

function InputGroupStrap() {

    const [open, setOpen] = useState(false);

    return(
        <>
            <InputGroup>
                <InputGroupAddon addonType="prepend">@</InputGroupAddon>
                <Input placeholder="username"/>
            </InputGroup>
            <br/>
            <InputGroup>
                <InputGroupAddon addonType="prepend">
                    <InputGroupText>
                        <Input addon type="checkbox" aria-label="Checkbos for following text input"/>
                    </InputGroupText>
                </InputGroupAddon>
                <Input placeholder="Check it out"/>
            </InputGroup>
            <br/>
            <InputGroup>
                <Input placeholder="username"/>
                <InputGroupAddon addonType="append">@example.com</InputGroupAddon>
            </InputGroup>
            <br/>
            <InputGroup> 
                <InputGroupAddon addonType="prepend">$</InputGroupAddon>
                <Input placeholder="Amount" type="number" step="1"/>
                <InputGroupAddon addonType="append">.00</InputGroupAddon>
            </InputGroup>
            <br/>
            <InputGroup>
                <InputGroupButtonDropdown addonType="prepend" isOpen={open} toggle={()=>setOpen(!open)}>
                    <DropdownToggle caret>Split outline</DropdownToggle>
                    <DropdownMenu>
                        <DropdownItem header>Header</DropdownItem>
                        <DropdownItem disabled>Action</DropdownItem>
                        <DropdownItem>Another Action</DropdownItem>
                        <DropdownItem divider/>
                        <DropdownItem>Another Action</DropdownItem>
                    </DropdownMenu>
                </InputGroupButtonDropdown>
                <Input/>
            </InputGroup>
        </>
    )
}

export default InputGroupStrap; 