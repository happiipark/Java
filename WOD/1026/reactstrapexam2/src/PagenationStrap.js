import { Pagination, PaginationItem, PaginationLink } from "reactstrap";

function PagenationStrap(){
    return(
        <div>
            <Pagination size="lg">
                <PaginationItem disabled>
                    <PaginationLink previous href="#"/>
                </PaginationItem>
                <PaginationItem active>
                    <PaginationLink previous href="?page=1">1</PaginationLink>
                </PaginationItem>
                <PaginationItem>
                    <PaginationLink previous href="?page=2">2</PaginationLink>
                </PaginationItem>
                <PaginationItem>
                    <PaginationLink previous href="?page=3">3</PaginationLink>
                </PaginationItem>
                <PaginationItem>
                    <PaginationLink previous href="?page=4">4</PaginationLink>
                </PaginationItem>
                <PaginationItem>
                    <PaginationLink previous href="?page=5">5</PaginationLink>
                </PaginationItem>
                <PaginationItem>
                    <PaginationLink next href="#"/>
                </PaginationItem>
            </Pagination>
        </div>
    )
}

export default PagenationStrap;