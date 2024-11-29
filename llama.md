#  llama

## ollama

https://ollama.com/

ollama create alberti -f ./albertito.txt

https://hub.docker.com/r/ollama/ollama
export LLAMA_CHECKPOINT_DIR=C:\Users\TONI\.llama

docker run -d --gpus=all -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
ollama create albert1b -f ./ModelFileAlbert1b.txt



curl http://localhost:11434/api/create -d '{"name": "mario","modelfile": "FROM llama3\nSYSTEM You are mario from Super Mario Bros."}'


## llama-stack
pip install llama-stack
https://www.llama.com/llama-downloads/
llama model list
llama model download --source meta --model-id  Llama3.2-1B
export LLAMA_CHECKPOINT_DIR=C:\Users\TONI\.llama

# Otras IA

https://easywithai.com/


## localai
https://localai.io/
* docker run -p 8080:8080 --name local-ai -ti localai/localai:latest-aio-cpu


## litellm
* https://github.com/BerriAI/litellm
* https://docs.litellm.ai/docs/
* >litellm --model ollama/llama3.1:latest





## g4f

docker pull hlohaus789/g4f
docker run   -p 8080:8080 -p 1337:1337 -p 7900:7900 --shm-size="2g"  -v %cd%\\har_and_cookies:/app/har_and_cookies  -v %cd%\\generated_images:/app/generated_images hlohaus789/g4f:latest


* https://docs.gpt4all.io/
* https://github.com/zukixa/cool-ai-stuff
* https://g4f.mintlify.app/docs/misc/contributing


## Google
* https://aistudio.google.com/app/gallery
* https://idx.google.com/templates?category=misc
* https://github.com/google/pytype
* https://mediapipe-studio.webapps.google.com/home




## AI

* https://www.tensorflow.org/tutorials/images/transfer_learning?hl=es-419
* https://keras.io/guides/transfer_learning/

## TTS - STT
https://github.com/RHVoice/RHVoice
https://github.com/mozilla/DeepSpeech
https://github.com/mobiusml/faster-whisper
https://github.com/k2-fsa/sherpa-onnx



## llamafiler

llamafiler -m Llama-3.2-1B-Instruct-Q3_K_L.gguf -l 0.0.0.0:8081
llamafile -m Llama-3.2-1B-Instruct-Q3_K_L.gguf --mmproj Llama-3.2-1B-Instruct-Q3_K_L.gguf --host 0.0.0.0
llamafile -m llava-v1.5-7b-Q8_0.gguf --mmproj llava-v1.5-7b-Q8_0.gguf --host 0.0.0.0



## VLLM
 Easy, fast, and cheap LLM serving for everyone.
* https://github.com/vllm-project/vllm
* https://huggingface.co/tiiuae/falcon-rw-1b/tree/main?local-app=vllm



docker pull unclecode/crawl4ai:latest
docker run -d -p 8000:80 unclecode/crawl4ai:latest
https://github.com/clovaai/donut?tab=readme-ov-file


## Fairseq
Fairseq(-py) is a sequence modeling toolkit that allows researchers and developers to train custom models for translation, summarization, language modeling and other text generation tasks.
https://github.com/facebookresearch/fairseq/tree/main


## NeMo
https://github.com/NVIDIA/NeMo
docker pull nvcr.io/nvidia/nemo:24.05
docker run --gpus all -it --rm -v <nemo_github_folder>:/NeMo --shm-size=8g -p 8888:8888 -p 6006:6006 --ulimit memlock=-1 --ulimit stack=67108864 --device=/dev/snd nvcr.io/nvidia/pytorch:23.10-py3




https://github.com/3b1b/manim?tab=readme-ov-file
https://docs.manim.community/en/stable/installation/docker.html
https://hub.docker.com/r/manimcommunity/manim



## Meta-agent
https://github.com/Jeomon/Meta-Agent-with-More-Agents


## CUDA
https://developer.nvidia.com/cuda-12-4-0-download-archive?target_os=Windows&target_arch=x86_64&target_version=11&target_type=exe_local


## cursos
https://github.com/mlabonne/llm-course


https://huggingface.co/blog/mlabonne/sft-llama3


## datos.gob.es
https://datos.gob.es/es/blog/por-que-deberias-de-usar-ficheros-parquet-si-procesas-muchos-datos




https://github.com/huggingface/transformers/tree/main

