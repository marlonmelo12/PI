interface ButtonInterface {
    text: String;
}

export default function Button({text} : ButtonInterface) {
    return (
        <div>
            <p>{text}</p>
        </div>
    )
}