payload='{"event_type":"avatar_video.success","event_data":{"video_id":"videoId"}}'

signature=$(printf '%s' "$payload" | openssl dgst -sha256 -hmac "secret" -hex | sed 's/^.* //')

curl -i -X POST "http://localhost:8080/api/v1/video/hook" \
  -H "Content-Type: application/json" \
  -H "Heygen-Signature: $signature" \
  --data "$payload"