import {UncontrolledCarousel} from 'reactstrap';

function CarouselStrap(){
    const items = [
        {
            src:"duck.png",
            altText:"고라파덕",
            caption:"고라파덕",
            header:"고라파덕"
        },
        {
            src:"doran.png",
            altText:"야도란",
            caption:"야도란",
            header:"야도란"
        },
        {
            src:"tang.png",
            altText:"탕구리",
            caption:"탕구리",
            header:"탕구리"
        }
    ]
    return(
        <>
            <UncontrolledCarousel items={items}/>
        </>
    )
}

export default CarouselStrap;