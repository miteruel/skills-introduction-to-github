# Welcome to llama

For full documentation visit [mkdocs.org](https://www.mkdocs.org).

## Commands

https://easywithai.com/

https://localai.io/
* docker run -p 8080:8080 --name local-ai -ti localai/localai:latest-aio-cpu

* >litellm --model ollama/llama3.1:latest

https://github.com/BerriAI/litellm

https://docs.litellm.ai/docs/



https://huggingface.co/settings/tokens/new?tokenType=fineGrained
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



vllm
* docker pull vllm/vllm-openai:v0.6.1.post2
docker run  --gpus all -v ~/.cache/huggingface:/root/.cache/huggingface --env "HUGGING_FACE_HUB_TOKEN=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" -p 8000:8000 --ipc=host vllm/vllm-openai:latest --model meta-llama/Llama-3.2-1B



## Project layout

    mkdocs.yml    # The configuration file.
    docs/
        index.md  # The documentation homepage.
        ...       # Other markdown pages, images and other files.


## g4f
https://g4f.mintlify.app/docs/misc/contributing

docker pull hlohaus789/g4f
docker run   -p 8080:8080 -p 1337:1337 -p 7900:7900 --shm-size="2g"  -v %cd%\\har_and_cookies:/app/har_and_cookies  -v %cd%\\generated_images:/app/generated_images hlohaus789/g4f:latest


https://docs.gpt4all.io/

https://github.com/zukixa/cool-ai-stuff



https://aistudio.google.com/app/gallery
https://idx.google.com/templates?category=misc



 https://github.com/clovaai/donut?tab=readme-ov-file




docker pull localstack/localstack:latest

https://www.tensorflow.org/tutorials/images/transfer_learning?hl=es-419
https://keras.io/guides/transfer_learning/

https://github.com/RHVoice/RHVoice
https://github.com/mozilla/DeepSpeech
https://github.com/mobiusml/faster-whisper
https://github.com/k2-fsa/sherpa-onnx

docker pull unclecode/crawl4ai:latest
docker run -d -p 8000:80 unclecode/crawl4ai:latest




llamafiler -m Llama-3.2-1B-Instruct-Q3_K_L.gguf -l 0.0.0.0:8081
llamafile -m Llama-3.2-1B-Instruct-Q3_K_L.gguf --mmproj Llama-3.2-1B-Instruct-Q3_K_L.gguf --host 0.0.0.0
llamafile -m llava-v1.5-7b-Q8_0.gguf --mmproj llava-v1.5-7b-Q8_0.gguf --host 0.0.0.0




https://github.com/facebookresearch/fairseq/tree/main

https://github.com/google/pytype


https://mediapipe-studio.webapps.google.com/home

https://huggingface.co/tiiuae/falcon-rw-1b/tree/main

VLLM

https://huggingface.co/tiiuae/falcon-rw-1b/tree/main?local-app=vllm



docker pull nvcr.io/nvidia/nemo:24.05
docker run --gpus all -it --rm -v <nemo_github_folder>:/NeMo --shm-size=8g -p 8888:8888 -p 6006:6006 --ulimit memlock=-1 --ulimit stack=67108864 --device=/dev/snd nvcr.io/nvidia/pytorch:23.10-py3




https://github.com/3b1b/manim?tab=readme-ov-file
https://docs.manim.community/en/stable/installation/docker.html
https://hub.docker.com/r/manimcommunity/manim



Meta-agent
https://github.com/Jeomon/Meta-Agent-with-More-Agents


CUDA
https://developer.nvidia.com/cuda-12-4-0-download-archive?target_os=Windows&target_arch=x86_64&target_version=11&target_type=exe_local



https://github.com/mlabonne/llm-course
https://huggingface.co/blog/mlabonne/sft-llama3

https://datos.gob.es/es/blog/por-que-deberias-de-usar-ficheros-parquet-si-procesas-muchos-datos


pip install llama-stack

https://www.llama.com/llama-downloads/
llama model list
llama model download --source meta --model-id  Llama3.2-1B
https://llama3-2-lightweight.llamameta.net/*?Policy=eyJTdGF0ZW1lbnQiOlt7InVuaXF1ZV9oYXNoIjoiOGxrMXIzMGE5dm8yOWh4amU3aXk1eXMyIiwiUmVzb3VyY2UiOiJodHRwczpcL1wvbGxhbWEzLTItbGlnaHR3ZWlnaHQubGxhbWFtZXRhLm5ldFwvKiIsIkNvbmRpdGlvbiI6eyJEYXRlTGVzc1RoYW4iOnsiQVdTOkVwb2NoVGltZSI6MTcyNzcyNjAwOX19fV19&Signature=Z1PqYbhMNBAnGmxAlPQE6YKyTc6vHtKa0lGnH6ncVCfFNRyIxcjewBxz8PDY4ss45QqnRpqMNpYfNCEqmgInpskY0rITU%7E9%7E%7E1cgySQCaCbXFlXztdkCVzff0W-W-2Sqkdmo7cG5zbS5tnLteAkS7M8K1cGyxftDYon9cTtQg-nKzkwEwpo4327gNC11H-vnirD7nl0m0FIcGpCiUYYSiV2HKrvXLrDUDQLEB6Hp%7Eg2tIoA48KUvbjg1r06PPQQNAsx5OK-pMpp-c6qTegF3KPeAKukyPl2DNd1ik6rQeq9wdejgWGD8d-soTxJAvqklouMowswFzBDt6aXJVtoaJQ__&Key-Pair-Id=K15QRJLYKIFSLZ&Download-Request-ID=1010128574242980

ollama create alberti -f ./albertito.txt

https://hub.docker.com/r/ollama/ollama
export LLAMA_CHECKPOINT_DIR=C:\Users\TONI\.llama

docker run -d --gpus=all -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
ollama create albert1b -f ./ModelFileAlbert1b.txt

curl http://localhost:11434/api/create -d '{"name": "mario","modelfile": "FROM llama3\nSYSTEM You are mario from Super Mario Bros."}'



export LLAMA_CHECKPOINT_DIR=C:\Users\TONI\.llama

# llamafiler
llamafiler -m Llama-3.2-1B-Instruct-Q3_K_L.gguf -l 0.0.0.0:8081

llamafile -m Llama-3.2-1B-Instruct-Q3_K_L.gguf --mmproj Llama-3.2-1B-Instruct-Q3_K_L.gguf --host 0.0.0.0
llamafile -m llava-v1.5-7b-Q8_0.gguf --mmproj llava-v1.5-7b-Q8_0.gguf --host 0.0.0.0



https://github.com/huggingface/transformers/tree/main



docker run -d --gpus=all -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama

https://www.phidata.app/settings
phi-sWTBOl6Mq68xJHBIb3kek1zp4XXopStFizK6W_WI4rI


docker build -f ./docker/docker-cuda/Dockerfile --build-arg INSTALL_BNB=false --build-arg INSTALL_VLLM=false --build-arg INSTALL_DEEPSPEED=false --build-arg INSTALL_FLASHATTN=false --build-arg PIP_INDEX=https://pypi.org/simple -t llamafactory:latest .
1
docker run -dit --gpus=all -v ./hf_cache:/root/.cache/huggingface -v ./ms_cache:/root/.cache/modelscope -v ./om_cache:/root/.cache/openmind -v ./data:/app/data -v ./output:/app/output -p 7860:7860 -p 8000:8000 --shm-size 16G --name llamafactory llamafactory:latest


https://github.com/facebookresearch/xformers
pip3 install -U xformers --index-url https://download.pytorch.org/whl/cu124

https://github.com/woct0rdho/triton-windows/tree/readme