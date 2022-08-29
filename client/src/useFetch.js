import { useState, useEffect } from "react";

const useFetch = (url) => {

    const [data, setData] = useState(null);  
    const [error, setError] = useState(null);

    useEffect(() => {
        const abortCont = new AbortController();

        setTimeout(() => {
            fetch(url, {signal: abortCont.ignal})
                .then(res => {                    
                    if(!res.ok) {
                        throw Error('could not fetch the data for that resouce')
                    }
                    return res.json()
                })
                .then(data => {                
                    setData(data)
                    setError(null)
                })
                .catch((err) => {
                    if (err.name === 'AbortError') {
                        console.log('fetch aborted')
                    } else {                        
                        setError(err.message);
                    }
                })
        })

        return () => abortCont.abort();
    }, [url])

    return { data, error}
   
}

export default useFetch;